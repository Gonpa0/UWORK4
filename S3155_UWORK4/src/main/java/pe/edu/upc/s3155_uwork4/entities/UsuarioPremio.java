package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioPremio")
public class UsuarioPremio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPremio", nullable = false)
    private Premio premio;

    public UsuarioPremio() {
    }

    public UsuarioPremio(int id, Usuario usuario, Premio premio) {
        this.id = id;
        this.usuario = usuario;
        this.premio = premio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }
}


