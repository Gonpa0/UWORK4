package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Valoracion;

import java.util.List;

public interface IValoracionService {
    public List<Valoracion> listar();
    public void Registrar(Valoracion v);
    public Valoracion listarporid(int id);
    public void Modificar(Valoracion v);
    public void Eliminar(int id);
}
