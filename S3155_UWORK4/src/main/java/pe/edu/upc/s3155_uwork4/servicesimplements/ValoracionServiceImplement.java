package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Valoracion;
import pe.edu.upc.s3155_uwork4.repositories.IValoracionRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IValoracionService;

import java.util.List;

@Service
public class ValoracionServiceImplement implements IValoracionService {
    @Autowired
    private IValoracionRepository vR;

    @Override
    public List<Valoracion> listar() {
        return vR.findAll();
    }

    @Override
    public void Registrar(Valoracion v){
        vR.save(v);
    }

    @Override
    public Valoracion listarporid(int id){
        return vR.findById(id).orElse(new Valoracion());
    }

    @Override
    public void Modificar(Valoracion v){
        vR.save(v);
    }

    @Override
    public void Eliminar(int id){
        vR.deleteById(id);
    }
}
