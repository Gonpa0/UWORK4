package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;


public class ArchivoDTO {
    private int id;
    private String nombreArchivo;
    private LocalDate fechaSubida;
    private Usuario usuario;
    private Asesoria asesoria;
    private FormatoArchivo formatoArchivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDate fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
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

    public FormatoArchivo getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(FormatoArchivo formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }
}
