package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UsuarioPremio")
public class UsuarioPremio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioPremio;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPremio", nullable = false)
    private Premio premio;

    @Column(name = "cantidadPremios", nullable = false)
    private int cantidadPremios;

    @Column(name = "fechaObtencion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaObtencion;

    public UsuarioPremio() {
    }

    public UsuarioPremio(int idUsuarioPremio, Usuario usuario, Premio premio, int cantidadPremios, Date fechaObtencion) {
        this.idUsuarioPremio = idUsuarioPremio;
        this.usuario = usuario;
        this.premio = premio;
        this.cantidadPremios = cantidadPremios;
        this.fechaObtencion = fechaObtencion;
    }

    public int getIdUsuarioPremio() {
        return idUsuarioPremio;
    }

    public void setIdUsuarioPremio(int idUsuarioPremio) {
        this.idUsuarioPremio = idUsuarioPremio;
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

    public int getCantidadPremios() {
        return cantidadPremios;
    }

    public void setCantidadPremios(int cantidadPremios) {
        this.cantidadPremios = cantidadPremios;
    }

    public Date getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(Date fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
}

