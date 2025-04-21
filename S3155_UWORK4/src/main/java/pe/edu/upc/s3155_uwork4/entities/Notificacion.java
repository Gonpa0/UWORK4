package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "contenido", nullable = false, length = 255)
    private String contenido;

    @Column(name = "ledio", nullable = false)
    private boolean ledio;

    @Column(name = "FechaNotificacion", nullable = false)
    private LocalDateTime fechaNotificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Notificacion() {

    }
    public Notificacion(int idNotificacion, String contenido, boolean ledio, LocalDateTime fechaNotificacion, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.contenido = contenido;
        this.ledio = ledio;
        this.fechaNotificacion = fechaNotificacion;
        this.usuario = usuario;
    }

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
