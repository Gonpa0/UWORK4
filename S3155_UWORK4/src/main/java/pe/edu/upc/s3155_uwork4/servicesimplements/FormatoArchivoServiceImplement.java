package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;
import pe.edu.upc.s3155_uwork4.repositories.IFormatoArchivoRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IFormatoArchivoService;

import java.util.List;
@Service
public class FormatoArchivoServiceImplement implements IFormatoArchivoService {
    @Autowired
    private IFormatoArchivoRepository faR;

    @Override
    public List<FormatoArchivo> listar() {
        return faR.findAll();
    }

    @Override
    public void Registrar(FormatoArchivo me){
        faR.save(me);
    }

    @Override
    public FormatoArchivo listarporid(int id){
        return faR.findById(id).orElse(new FormatoArchivo());
    }

    @Override
    public void Modificar(FormatoArchivo me){
        faR.save(me);
    }

    @Override
    public void Eliminar(int id){
        faR.deleteById(id);
    }
}
