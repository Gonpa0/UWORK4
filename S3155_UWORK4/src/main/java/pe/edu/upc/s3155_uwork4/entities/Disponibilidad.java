package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDisponibilidad;

    @Column(name = "fechaDisponibilidad", nullable = false)
    private LocalDate fechaDisponibilidad;

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Disponibilidad() {
    }

    public Disponibilidad(int idDisponibilidad, LocalDate fechaDisponibilidad, LocalTime horaInicio, LocalTime horaFin, Usuario usuario) {
        this.idDisponibilidad = idDisponibilidad;
        this.fechaDisponibilidad = fechaDisponibilidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.usuario = usuario;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public LocalDate getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(LocalDate fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
