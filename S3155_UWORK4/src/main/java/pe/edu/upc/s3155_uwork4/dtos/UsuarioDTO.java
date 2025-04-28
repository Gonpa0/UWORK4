package pe.edu.upc.s3155_uwork4.dtos;


import pe.edu.upc.s3155_uwork4.entities.Rol;

public class UsuarioDTO {
    private int idUsuario;
    private String username;
    private String correo;
    private String password;
    private int ciclo;
    private int puntos;
    private String carrera;
    private String centro_de_estudios;
    private Rol rol;
    private Boolean estado;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
