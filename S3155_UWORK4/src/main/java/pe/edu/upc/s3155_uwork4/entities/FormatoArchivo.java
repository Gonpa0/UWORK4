package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "FormatoArchivo")
public class FormatoArchivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "formatoArchivo",length = 1000, nullable = false)
    private String formatoArchivo;
    @Column(name ="extension",length = 1000, nullable = false)
    private String extension;

    public FormatoArchivo() {
    }

    public FormatoArchivo(int id, String formatoArchivo, String extension) {
        this.id = id;
        this.formatoArchivo = formatoArchivo;
        this.extension = extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(String formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
