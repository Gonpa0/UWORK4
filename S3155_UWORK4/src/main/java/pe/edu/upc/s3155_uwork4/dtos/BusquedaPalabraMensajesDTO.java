package pe.edu.upc.s3155_uwork4.dtos;

import java.time.LocalDate;

public class BusquedaPalabraMensajesDTO {
    private int id_mensaje;
    private int orden;
    private String contenido;
    private LocalDate fecha_mensaje;
    private int id_asesoria;
    private int id_usuario;

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public LocalDate getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(LocalDate fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
