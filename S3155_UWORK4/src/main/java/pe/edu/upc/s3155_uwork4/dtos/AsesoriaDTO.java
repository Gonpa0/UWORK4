package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;

public class AsesoriaDTO {
    private int idAsesoria;
    private String nombreAsesoria;
    private LocalDate fechaAsesoria;
    private Usuario usuarioInferior;
    private Usuario usuarioSuperior;

    public int getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public String getNombreAsesoria() {
        return nombreAsesoria;
    }

    public void setNombreAsesoria(String nombreAsesoria) {
        this.nombreAsesoria = nombreAsesoria;
    }

    public LocalDate getFechaAsesoria() {
        return fechaAsesoria;
    }

    public void setFechaAsesoria(LocalDate fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    public Usuario getUsuarioInferior() {
        return usuarioInferior;
    }

    public void setUsuarioInferior(Usuario usuarioInferior) {
        this.usuarioInferior = usuarioInferior;
    }

    public Usuario getUsuarioSuperior() {
        return usuarioSuperior;
    }

    public void setUsuarioSuperior(Usuario usuarioSuperior) {
        this.usuarioSuperior = usuarioSuperior;
    }
}
