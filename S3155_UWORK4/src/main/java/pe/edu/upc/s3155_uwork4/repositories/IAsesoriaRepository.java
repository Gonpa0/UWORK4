package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;

import java.util.List;

@Repository
public interface IAsesoriaRepository extends JpaRepository<Asesoria, Integer> {

    @Query(value = "SELECT fecha_asesoria, COUNT(*) \n" +
            "FROM asesoria \n" +
            "GROUP BY fecha_asesoria \n" +
            "ORDER BY fecha_asesoria;", nativeQuery = true)
    public List<String[]> Asesoriaporfecha();
    @Query(value="SELECT  \n" +
            "  m.id_mensaje,\n" +
            "  m.contenido,\n" +
            "  m.fecha_mensaje,\n" +
            "  a.id_asesoria,\n" +
            "  a.fecha_registro\n" +
            "FROM mensaje m\n" +
            "JOIN asesoria a ON m.id_asesoria = a.id_asesoria\n" +
            "WHERE a.fecha_registro > '2025-03-15';\n", nativeQuery = true)
    public List<String[]> Asesoriadespuesdeciertafecha();

}
