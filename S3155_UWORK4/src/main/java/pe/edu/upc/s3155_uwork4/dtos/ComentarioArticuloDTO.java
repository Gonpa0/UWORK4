package pe.edu.upc.s3155_uwork4.dtos;


import pe.edu.upc.s3155_uwork4.entities.Articulo;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;

public class ComentarioArticuloDTO {
    private int idComentario;
    private String contenido;
    private LocalDate fecha;
    private Articulo articulo;
    private Usuario usuario;

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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
