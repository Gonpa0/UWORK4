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

    List<Asesoria> findByUsuarioInferiorIdUsuarioOrUsuarioSuperiorIdUsuario(int idInferior, int idSuperior);



}
