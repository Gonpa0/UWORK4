package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Asesoria;

import java.util.List;

public interface IAsesoriaService {
    public List<Asesoria> listar();
    public void Registrar(Asesoria a);
    public Asesoria listarporid(int id);
    public void Modificar(Asesoria a);
    public void Eliminar(int id);

}
