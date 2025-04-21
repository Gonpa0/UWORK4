package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.Rol;
import pe.edu.upc.s3155_uwork4.repositories.IAsesoriaRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IAsesoriaService;

import java.util.List;
@Service
public class AsesoriaServiceImplement implements IAsesoriaService {
    @Autowired
    private IAsesoriaRepository aR;

    @Override
    public List<Asesoria> list() {
        return aR.findAll();
    }

    @Override
    public void Registrar(Asesoria a){
        aR.save(a);
    }

    @Override
    public Asesoria listarporid(int id){
        return aR.findById(id).orElse(new Asesoria());
    }

    @Override
    public void Modificar(Asesoria a){
        aR.save(a);
    }

    @Override
    public void Eliminar(int id){
        aR.deleteById(id);
    }

}
