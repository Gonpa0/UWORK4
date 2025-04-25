package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.ComentarioArticulo;

import java.util.List;

public interface IComentarioArticuloService {
    public List<ComentarioArticulo> listar();
    public void Registrar(ComentarioArticulo comenArti);
    public ComentarioArticulo listarporid(int id);
    public void Modificar(ComentarioArticulo comenArti);
    public void Eliminar(int id);
}
