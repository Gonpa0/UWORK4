package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Disponibilidad;

import java.util.List;

public interface IDisponibilidadService {
    public List<Disponibilidad> listar();
    public void Registrar(Disponibilidad disponibilidad);
    public Disponibilidad listarporid(int id);
    public void Modificar(Disponibilidad disponibilidad);
    public void Eliminar(int id);
}
