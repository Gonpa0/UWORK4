package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Archivo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IArchivoRepository extends JpaRepository<Archivo, Integer> {


//QUERY
@Query("SELECT arch FROM Archivo arch WHERE arch.usuario.idUsuario = :idUsuario AND arch.fechaSubida = :fechaSubida")
List<Archivo> buscarPorIDYFecha(@Param("idUsuario") int idUsuario, @Param("fechaSubida") LocalDate fechaSubida);
}
