package pe.edu.upc.s3155_uwork4.dtos;

import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.time.LocalDate;

public class AsesoriaporfechaDTO {

    private LocalDate fecha_Asesoria;

    public LocalDate getFecha_Asesoria() {
        return fecha_Asesoria;
    }

    public void setFecha_Asesoria(LocalDate fecha_Asesoria) {
        this.fecha_Asesoria = fecha_Asesoria;
    }
}
