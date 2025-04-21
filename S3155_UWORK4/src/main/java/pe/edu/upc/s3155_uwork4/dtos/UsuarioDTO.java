package pe.edu.upc.s3155_uwork4.dtos;


import pe.edu.upc.s3155_uwork4.entities.Rol;

public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String correo;
    private String contrasenia;
    private int ciclo;
    private int puntos;
    private String carrera;
    private String centro_de_estudios;
    private Rol rol;

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
