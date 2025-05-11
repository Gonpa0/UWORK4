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
}
