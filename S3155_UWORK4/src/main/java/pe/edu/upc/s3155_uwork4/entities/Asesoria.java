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
    private Usuario idusuarioInferior;
    @ManyToOne
    @JoinColumn(name = "idUsuarioSuperior")
    private Usuario idusuarioSuperior;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria, String nombreAsesoria, LocalDate fechaAsesoria, Usuario idusuarioInferior, Usuario idusuarioSuperior) {
        this.idAsesoria = idAsesoria;
        this.nombreAsesoria = nombreAsesoria;
        this.fechaAsesoria = fechaAsesoria;
        this.idusuarioInferior = idusuarioInferior;
        this.idusuarioSuperior = idusuarioSuperior;
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

    public Usuario getIdusuarioInferior() {
        return idusuarioInferior;
    }

    public void setIdusuarioInferior(Usuario idusuarioInferior) {
        this.idusuarioInferior = idusuarioInferior;
    }

    public Usuario getIdusuarioSuperior() {
        return idusuarioSuperior;
    }

    public void setIdusuarioSuperior(Usuario idusuarioSuperior) {
        this.idusuarioSuperior = idusuarioSuperior;
    }
}
