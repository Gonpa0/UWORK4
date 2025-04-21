package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;

public class MensajeDTO {
    private int idMensaje;
    private String contenido;
    private LocalDate fechaMensaje;
    private int Orden;
    private Usuario usuario;
    private Asesoria asesoria;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int orden) {
        Orden = orden;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }
}
