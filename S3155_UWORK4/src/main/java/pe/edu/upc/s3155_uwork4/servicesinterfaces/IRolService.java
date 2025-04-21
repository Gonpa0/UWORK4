package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listar();
    public void Registrar(Rol r);
    public Rol listarporid(int id);
    public void Modificar(Rol r);
    public void Eliminar(int id);
}
