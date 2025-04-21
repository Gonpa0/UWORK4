package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombreUsuario", nullable = false, length = 50)
    private String nombreUsuario;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasenia", nullable = false, length = 50)
    private String contrasenia;

    @Column(name = "ciclo", nullable = false)
    private int ciclo;

    @Column(name = "puntos", nullable = false)
    private int puntos;

    @Column(name = "carrera", nullable = false, length = 100)
    private String carrera;

    @Column(name = "centro_de_estudios", nullable = false, length = 100)
    private String centro_de_estudios;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;


    public Usuario() {

    }

    public Usuario(int idUsuario, Rol rol, String centro_de_estudios, String carrera, int puntos, int ciclo, String contrasenia, String correo, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.rol = rol;
        this.centro_de_estudios = centro_de_estudios;
        this.carrera = carrera;
        this.puntos = puntos;
        this.ciclo = ciclo;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCentro_de_estudios() {
        return centro_de_estudios;
    }

    public void setCentro_de_estudios(String centro_de_estudios) {
        this.centro_de_estudios = centro_de_estudios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
