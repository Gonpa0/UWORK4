package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();
    public void Registrar(Usuario u);
    public Usuario listarporid(int id);
    public void Modificar(Usuario u);
    public void Eliminar(int id);
}
