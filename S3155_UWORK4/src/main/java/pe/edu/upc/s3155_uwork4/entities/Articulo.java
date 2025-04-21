package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "contenido",nullable = false)
    private String contenido;

    @Column(name = "fecha" , nullable = false)
    private LocalDate fecha;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Articulo() {
    }

    public Articulo(int idArticulo, String titulo, String contenido, LocalDate fecha, String autor, Usuario usuario) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
        this.usuario = usuario;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
