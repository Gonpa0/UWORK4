package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

    @Query(value="SELECT \n" +
            "  CASE \n" +
            "    WHEN u.ciclo >= 6 THEN 'Ciclo Superior'\n" +
            "    WHEN u.ciclo >= 1 THEN 'Ciclo Inferior'\n" +
            "  END AS grupo_ciclo,\n" +
            "  COUNT(n.id_notificacion) AS total_notificaciones,\n" +
            "  COUNT(DISTINCT u.id_usuario) AS total_usuarios,\n" +
            "  ROUND(1.0 * COUNT(n.id_notificacion) / COUNT(DISTINCT u.id_usuario), 2) AS promedio_por_usuario\n" +
            "FROM notificacion n\n" +
            "JOIN usuario u ON n.id_usuario = u.id_usuario\n" +
            "WHERE u.ciclo >= 1\n" +
            "GROUP BY grupo_ciclo;", nativeQuery = true)
    public List<String[]> ComparacionPorGrupoCicloPromedioNotificaciones();
}
