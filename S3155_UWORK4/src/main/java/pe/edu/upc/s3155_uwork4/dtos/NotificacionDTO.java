package pe.edu.upc.s3155_uwork4.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDateTime;

public class NotificacionDTO {
    private int idNotificacion;
    private String contenido;
    private boolean ledio;
    private LocalDateTime fechaNotificacion;
    private Usuario usuario;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isLedio() {
        return ledio;
    }

    public void setLedio(boolean ledio) {
        this.ledio = ledio;
    }

    public LocalDateTime getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalDateTime fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
