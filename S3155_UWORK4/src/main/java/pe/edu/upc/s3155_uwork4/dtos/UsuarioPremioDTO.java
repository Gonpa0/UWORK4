package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.entities.Premio;

public class UsuarioPremioDTO {

    private int id;
    private Usuario usuario;
    private Premio premio;

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}


