package pe.edu.upc.s3155_uwork4.dtos;

import java.time.LocalDate;

public class AsesoriadespuesdeciertafechaDTO {
    private int id_asesoria;
    private LocalDate fecha_Asesoria;
    private String nombre_asesroia;
    private int id_usuario_inferior;
    private int id_usuario_superior;

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public LocalDate getFecha_Asesoria() {
        return fecha_Asesoria;
    }

    public void setFecha_Asesoria(LocalDate fecha_Asesoria) {
        this.fecha_Asesoria = fecha_Asesoria;
    }

    public String getNombre_asesroia() {
        return nombre_asesroia;
    }

    public void setNombre_asesroia(String nombre_asesroia) {
        this.nombre_asesroia = nombre_asesroia;
    }

    public int getId_usuario_inferior() {
        return id_usuario_inferior;
    }

    public void setId_usuario_inferior(int id_usuario_inferior) {
        this.id_usuario_inferior = id_usuario_inferior;
    }

    public int getId_usuario_superior() {
        return id_usuario_superior;
    }

    public void setId_usuario_superior(int id_usuario_superior) {
        this.id_usuario_superior = id_usuario_superior;
    }
}
