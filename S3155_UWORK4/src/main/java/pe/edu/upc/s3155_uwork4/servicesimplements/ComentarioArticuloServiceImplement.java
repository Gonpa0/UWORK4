package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.ComentarioArticulo;
import pe.edu.upc.s3155_uwork4.repositories.IComentarioArticuloRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IComentarioArticuloService;

import java.util.List;

@Service
public class ComentarioArticuloServiceImplement implements IComentarioArticuloService {

    @Autowired
    private IComentarioArticuloRepository comentarioArticuloRepository;


    @Override
    public List<ComentarioArticulo> listar() {
        return comentarioArticuloRepository.findAll();
    }

    @Override
    public void Registrar(ComentarioArticulo comenArti) {
    comentarioArticuloRepository.save(comenArti);
    }

    @Override
    public ComentarioArticulo listarporid(int id) {
        return comentarioArticuloRepository.findById(id).orElse(new ComentarioArticulo());
    }

    @Override
    public void Modificar(ComentarioArticulo comenArti) {
    comentarioArticuloRepository.save(comenArti);
    }

    @Override
    public void Eliminar(int id) {
    comentarioArticuloRepository.deleteById(id);
    }
}
