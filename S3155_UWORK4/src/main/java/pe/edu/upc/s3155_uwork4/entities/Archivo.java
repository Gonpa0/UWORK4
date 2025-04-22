package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Archivo")
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombreArchivo",length = 255, nullable = false)
    private String nombreArchivo;
    @Column(name = "fechaSubida",nullable = false)
    private LocalDate fechaSubida;

    @ManyToOne
    @JoinColumn(name = "idUsario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idAsesoria")
    private Asesoria asesoria;
    @ManyToOne
    @JoinColumn(name = "idFormatoArchivo")
    private FormatoArchivo formatoArchivo;

    public Archivo() {
    }

    public Archivo(int id, String nombreArchivo, LocalDate fechaSubida, Usuario usuario, Asesoria asesoria, FormatoArchivo formatoArchivo) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.fechaSubida = fechaSubida;
        this.usuario = usuario;
        this.asesoria = asesoria;
        this.formatoArchivo = formatoArchivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public LocalDate getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDate fechaSubida) {
        this.fechaSubida = fechaSubida;
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
