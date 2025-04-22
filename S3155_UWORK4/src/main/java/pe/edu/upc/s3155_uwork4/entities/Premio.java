package pe.edu.upc.s3155_uwork4.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Premio")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int categoria;

    @Column(name = "nombrePrem", nullable = false, length = 50)
    private String nombrePrem;

    @Column(nullable = false)
    private int puntos;

    // Relación One to Many con UsuarioPremio
    @OneToMany(mappedBy = "premio", cascade = CascadeType.ALL)
    private List<UsuarioPremio> usuarioPremios;

    // Constructores
    public Premio() {}

    public Premio(int id, int categoria, String nombrePrem, int puntos) {
        this.id = id;
        this.categoria = categoria;
        this.nombrePrem = nombrePrem;
        this.puntos = puntos;
    }

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

    public List<UsuarioPremio> getUsuarioPremios() {
        return usuarioPremios;
    }

    public void setUsuarioPremios(List<UsuarioPremio> usuarioPremios) {
        this.usuarioPremios = usuarioPremios;
    }
}

