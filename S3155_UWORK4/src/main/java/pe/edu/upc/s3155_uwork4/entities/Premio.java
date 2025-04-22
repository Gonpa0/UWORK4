package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Premio")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPremio;

    @Column(name = "nombrePremio", nullable = false, length = 100)
    private String nombrePremio;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "puntosRequeridos", nullable = false)
    private int puntosRequeridos;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    // Constructores
    public Premio() {
    }

    public Premio(int idPremio, String nombrePremio, String descripcion, int puntosRequeridos, Usuario usuario) {
        this.idPremio = idPremio;
        this.nombrePremio = nombrePremio;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(int idPremio) {
        this.idPremio = idPremio;
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public void setNombrePremio(String nombrePremio) {
        this.nombrePremio = nombrePremio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
