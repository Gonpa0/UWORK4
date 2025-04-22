package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Premio;
import pe.edu.upc.s3155_uwork4.repositories.IPremioRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IPremioService;

import java.util.List;

@Service
public class PremioServiceImplement implements IPremioService {

    @Autowired
    private IPremioRepository pR;

    @Override
    public List<Premio> listar() {
        return pR.findAll();
    }

    @Override
    public void Registrar(Premio p) {
        pR.save(p);
    }

    @Override
    public Premio listarporid(int id) {
        return pR.findById(id).orElse(new Premio());
    }

    @Override
    public void Modificar(Premio p) {
        pR.save(p);
    }

    @Override
    public void Eliminar(int id) {
        pR.deleteById(id);
    }
}
