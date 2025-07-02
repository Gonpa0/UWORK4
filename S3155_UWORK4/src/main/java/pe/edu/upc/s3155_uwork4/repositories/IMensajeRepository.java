package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Mensaje;

import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {

    @Query(value = "SELECT \n" +
            "  m.id_mensaje,\n" +
            "  m.orden,\n" +
            "  m.contenido,\n" +
            "  m.fecha_mensaje,\n" +
            "  m.id_asesoria,\n" +
            "  m.id_usuario\n" +
            "FROM mensaje m\n" +
            "JOIN usuario u ON m.id_usuario = u.id_usuario\n" +
            "WHERE u.ciclo < 6\n" +
            "  AND LOWER(m.contenido) LIKE '%examen%';", nativeQuery = true)
    public List<String[]> BusquedaPalabraMensajes();

    // PARA QUE FUNCIONE EL CHAT ASESORIA LISTAR MENSAJES POR ID DE ASESORIA
    @Query("SELECT m FROM Mensaje m WHERE m.asesoria.idAsesoria = :idAsesoria ORDER BY m.fechaMensaje ASC")
    List<Mensaje> listarPorAsesoriaId(@Param("idAsesoria") int idAsesoria);

}
