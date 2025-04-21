package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Asesoria")
public class Asesoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesoria;

    @Column(name = "nombreAsesoria", length = 50, nullable = false)
    private String nombreAsesoria;

    @Column(name = "fechaAsesoria",nullable = false)
    private LocalDate fechaAsesoria;



    @ManyToOne
    @JoinColumn(name = "idUsuarioInferior")
    private Usuario usuarioInferior;
    @ManyToOne
    @JoinColumn(name = "idUsuarioSuperior")
    private Usuario usuarioSuperior;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria, String nombreAsesoria, LocalDate fechaAsesoria, Usuario usuarioInferior, Usuario usuarioSuperior) {
        this.idAsesoria = idAsesoria;
        this.nombreAsesoria = nombreAsesoria;
        this.fechaAsesoria = fechaAsesoria;
        this.usuarioInferior = usuarioInferior;
        this.usuarioSuperior = usuarioSuperior;
    }

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
