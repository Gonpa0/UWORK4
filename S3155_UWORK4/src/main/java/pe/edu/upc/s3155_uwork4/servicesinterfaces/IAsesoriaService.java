package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.Rol;

import java.util.List;

public interface IAsesoriaService {
    public List<Asesoria> listar();
    public void Registrar(Asesoria r);
    public Asesoria listarporid(int id);
    public void Modificar(Asesoria r);
    public void Eliminar(int id);

}
