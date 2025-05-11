package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.repositories.IUsuarioRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;
    @Override
    public List<Usuario> listar() {
        return uR.findAll();
    }

    @Override
    public void Registrar(Usuario u) {
        uR.save(u);
    }

    @Override
    public Usuario listarporid(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    @Override
    public void Modificar(Usuario u) {
        uR.save(u);
    }

    @Override
    public void Eliminar(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<String[]> ListarUsernameSinPassword() {
        return uR.ListarUsernameSinPassword();
    }
}
