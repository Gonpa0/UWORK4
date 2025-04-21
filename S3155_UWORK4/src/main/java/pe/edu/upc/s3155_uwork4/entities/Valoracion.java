package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValoracion;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;


    @ManyToOne
    @JoinColumn(name = "idasesoria")
    private Asesoria asesoria;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Valoracion() {
    }

    public Valoracion(int idValoracion, int calificacion, Asesoria asesoria, Usuario usuario) {
        this.idValoracion = idValoracion;
        this.calificacion = calificacion;
        this.asesoria = asesoria;
        this.usuario = usuario;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
