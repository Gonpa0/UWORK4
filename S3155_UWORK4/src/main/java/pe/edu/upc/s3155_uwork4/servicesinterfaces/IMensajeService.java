package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    public List<Mensaje> listar();
    public void Registrar(Mensaje me);
    public Mensaje listarporid(int id);
    public void Modificar(Mensaje me);
    public void Eliminar(int id);
    public List<String[]> BusquedaPalabraMensajes();

    //listar mensajes por asesoria es clave para construir el chat asesoria

    public List<Mensaje> listarPorAsesoriaId(int idAsesoria);
}
