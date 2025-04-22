package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Articulo;

import java.util.List;

public interface IArticuloService {
    public List<Articulo> listar();
    public void Registrar(Articulo ar);
    public Articulo listarporid(int id);
    public void Modificar(Articulo ar);
    public void Eliminar(int id);
}
