package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> listar();
    public void Registrar(Notificacion n);
    public Notificacion listarporid(int id);
    public void Modificar(Notificacion n);
    public void Eliminar(int id);
    public List<String[]> ComparacionPorGrupoCicloPromedioNotificaciones();
}
