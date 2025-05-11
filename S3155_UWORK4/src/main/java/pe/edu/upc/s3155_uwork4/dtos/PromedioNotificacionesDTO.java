package pe.edu.upc.s3155_uwork4.dtos;

public class PromedioNotificacionesDTO {
    private String grupo_ciclo;
    private int total_notificaciones;
    private int total_usuarios;
    private double promedioNotificacionUsuario;

    public String getGrupo_ciclo() {
        return grupo_ciclo;
    }

    public void setGrupo_ciclo(String grupo_ciclo) {
        this.grupo_ciclo = grupo_ciclo;
    }

    public int getTotal_notificaciones() {
        return total_notificaciones;
    }

    public void setTotal_notificaciones(int total_notificaciones) {
        this.total_notificaciones = total_notificaciones;
    }

    public int getTotal_usuarios() {
        return total_usuarios;
    }

    public void setTotal_usuarios(int total_usuarios) {
        this.total_usuarios = total_usuarios;
    }

    public double getPromedioNotificacionUsuario() {
        return promedioNotificacionUsuario;
    }

    public void setPromedioNotificacionUsuario(double promedioNotificacionUsuario) {
        this.promedioNotificacionUsuario = promedioNotificacionUsuario;
    }
}
