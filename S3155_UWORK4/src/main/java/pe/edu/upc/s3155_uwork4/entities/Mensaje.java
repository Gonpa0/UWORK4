package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "contenido",length = 1000, nullable = false)
    private String contenido;

    @Column(name = "fechaMensaje", nullable = false)
    private LocalDate fechaMensaje;

    @Column(name = "Orden", nullable = false)
    private int Orden;

    @ManyToOne
    @JoinColumn(name = "idUsuario" )
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idAsesoria")
    private Asesoria asesoria;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenido, LocalDate fechaMensaje, int orden, Usuario usuario, Asesoria asesoria) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.fechaMensaje = fechaMensaje;
        Orden = orden;
        this.usuario = usuario;
        this.asesoria = asesoria;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
