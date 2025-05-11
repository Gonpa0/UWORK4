package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.s3155_uwork4.entities.Disponibilidad;

import java.time.LocalDate;
import java.util.List;

public interface IDisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {

    //QUERY CON JPQL
    @Query("SELECT d FROM Disponibilidad d WHERE d.usuario.idUsuario = :idUsuario AND d.fechaDisponibilidad = :fecha ORDER BY d.horaInicio ASC")
    List<Disponibilidad> buscarPorUsuarioYFecha(@Param("idUsuario") int idUsuario, @Param("fecha") LocalDate fecha);
}
