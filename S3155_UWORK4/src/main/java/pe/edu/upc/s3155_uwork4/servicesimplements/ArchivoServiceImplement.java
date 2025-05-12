package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Archivo;
import pe.edu.upc.s3155_uwork4.repositories.IArchivoRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArchivoService;

import java.time.LocalDate;
import java.util.List;
@Service
public class ArchivoServiceImplement implements IArchivoService {
    @Autowired
    private IArchivoRepository archivoRepository;

    @Override
    public List<Archivo> listar() {
        return archivoRepository.findAll();
    }

    @Override
    public void Registrar(Archivo arch) {
        archivoRepository.save(arch);
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

    //QUERY
    @Override
    public List<Archivo> buscarPorIDYFecha(int idUsuario, LocalDate fechaSubida) {
        return archivoRepository.buscarPorIDYFecha(idUsuario, fechaSubida);
    }
}
