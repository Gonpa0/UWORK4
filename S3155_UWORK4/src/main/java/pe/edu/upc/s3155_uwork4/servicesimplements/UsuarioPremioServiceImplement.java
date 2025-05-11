package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;
import pe.edu.upc.s3155_uwork4.repositories.IUsuarioPremioRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioPremioService;

import java.util.List;

@Service
public class UsuarioPremioServiceImplement implements IUsuarioPremioService {

    @Autowired
    private IUsuarioPremioRepository upR;

    @Override
    public List<UsuarioPremio> listar() {
        return upR.findAll();
    }

    @Override
    public void Registrar(UsuarioPremio up) {
        upR.save(up);
    }

    @Override
    public UsuarioPremio listarporid(int id) {
        return upR.findById(id).orElse(new UsuarioPremio());
    }

    @Override
    public void Modificar(UsuarioPremio up) {
        upR.save(up);
    }

    @Override
    public void Eliminar(int id) {
        upR.deleteById(id);
    }
}
