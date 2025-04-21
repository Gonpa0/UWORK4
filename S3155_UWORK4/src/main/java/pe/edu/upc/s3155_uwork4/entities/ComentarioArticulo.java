package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ComentarioArticulo")
public class ComentarioArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idArticulo")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public ComentarioArticulo() {
    }

    public ComentarioArticulo(int idComentario, String contenido, LocalDate fecha, Articulo articulo, Usuario usuario) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fecha = fecha;
        this.articulo = articulo;
        this.usuario = usuario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
