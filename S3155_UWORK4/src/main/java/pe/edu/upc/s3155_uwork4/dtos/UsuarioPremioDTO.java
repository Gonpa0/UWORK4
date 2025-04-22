package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.entities.Premio;

public class UsuarioPremioDTO {

    private int idUsuarioPremio;
    private Usuario usuario;
    private Premio premio;
    private int cantidadPremios;
    private String fechaObtencion;

    // Getter y Setter para idUsuarioPremio
    public int getIdUsuarioPremio() {
        return idUsuarioPremio;
    }

    public void setIdUsuarioPremio(int idUsuarioPremio) {
        this.idUsuarioPremio = idUsuarioPremio;
    }

    // Getter y Setter para usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para premio
    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    // Getter y Setter para cantidadPremios
    public int getCantidadPremios() {
        return cantidadPremios;
    }

    public void setCantidadPremios(int cantidadPremios) {
        this.cantidadPremios = cantidadPremios;
    }

    // Getter y Setter para fechaObtencion
    public String getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(String fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
}

