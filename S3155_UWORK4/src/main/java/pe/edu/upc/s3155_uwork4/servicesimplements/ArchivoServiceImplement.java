package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Archivo;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.repositories.IArchivoRepository;
import pe.edu.upc.s3155_uwork4.repositories.IAsesoriaRepository;
import pe.edu.upc.s3155_uwork4.repositories.IFormatoArchivoRepository;
import pe.edu.upc.s3155_uwork4.repositories.IUsuarioRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArchivoService;

import java.util.List;
@Service
public class ArchivoServiceImplement implements IArchivoService {
    @Autowired
    private IArchivoRepository archivoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IAsesoriaRepository asesoriaRepository;

    @Autowired
    private IFormatoArchivoRepository formatoArchivoRepository;


    @Override
    public List<Archivo> listar() {
        return archivoRepository.findAll();
    }

    @Override
    public void Registrar(Archivo nuevo) {
        // Asegurar que las entidades estén completas
        Usuario u = usuarioRepository.findById(nuevo.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Asesoria a = asesoriaRepository.findById(nuevo.getAsesoria().getIdAsesoria())
                .orElseThrow(() -> new RuntimeException("Asesoría no encontrada"));
        FormatoArchivo f = formatoArchivoRepository.findById(nuevo.getFormatoArchivo().getId())
                .orElseThrow(() -> new RuntimeException("Formato no encontrado"));

        nuevo.setUsuario(u);
        nuevo.setAsesoria(a);
        nuevo.setFormatoArchivo(f);

        archivoRepository.save(nuevo);
    }

    @Override
    public Archivo listarporid(int id) {
        return archivoRepository.findById(id).orElse(new Archivo());
    }

    @Override
    public void Modificar(Archivo arch) {
        archivoRepository.save(arch);
    }

    @Override
    public void Eliminar(int id) {
        archivoRepository.deleteById(id);
    }


    //METODO PARA LISTAR ARCHIVOS POR ID DE ASESORIA SERVICEIMPLEMENT
    @Override
    public List<Archivo> listarPorAsesoria(int idAsesoria) {
        return archivoRepository.findByAsesoriaIdAsesoria(idAsesoria);
    }
}