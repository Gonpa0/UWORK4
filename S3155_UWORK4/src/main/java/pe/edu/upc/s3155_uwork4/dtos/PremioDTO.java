package pe.edu.upc.s3155_uwork4.dtos;

public class PremioDTO {
    private int id;
    private int categoria;
    private String nombrePrem;
    private int puntos;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombrePrem() {
        return nombrePrem;
    }

    public void setNombrePrem(String nombrePrem) {
        this.nombrePrem = nombrePrem;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
