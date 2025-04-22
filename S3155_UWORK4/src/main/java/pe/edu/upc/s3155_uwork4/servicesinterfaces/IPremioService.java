package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Premio;

import java.util.List;

public interface IPremioService {
    public List<Premio> listar();
    public void Registrar(Premio p);
    public Premio listarporid(int id);
    public void Modificar(Premio p);
    public void Eliminar(int id);
}
