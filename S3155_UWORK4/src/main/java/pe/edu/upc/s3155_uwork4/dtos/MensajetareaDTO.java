package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;

public class MensajetareaDTO {
    private int id_Mensaje;
    private int orden;
    private String contenido;
    private LocalDate fecha_Mensaje;
    private int id_asesoria;
    private int id_usuario;

    public int getId_Mensaje() {
        return id_Mensaje;
    }

    public void setId_Mensaje(int id_Mensaje) {
        this.id_Mensaje = id_Mensaje;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha_Mensaje() {
        return fecha_Mensaje;
    }

    public void setFecha_Mensaje(LocalDate fecha_Mensaje) {
        this.fecha_Mensaje = fecha_Mensaje;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
