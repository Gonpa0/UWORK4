package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;

import java.util.List;

public interface IUsuarioPremioService {
    public List<UsuarioPremio> listar();
    public void Registrar(UsuarioPremio up);
    public UsuarioPremio listarporid(int id);
    public void Modificar(UsuarioPremio up);
    public void Eliminar(int id);
}
