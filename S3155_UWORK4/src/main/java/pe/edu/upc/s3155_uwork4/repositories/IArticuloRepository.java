package pe.edu.upc.s3155_uwork4.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Articulo;

import java.util.List;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo,Integer> {

    //QUERYS
    @Query("SELECT a FROM Articulo a WHERE LOWER(a.titulo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(a.contenido) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Articulo> buscarPorPalabraClave(@Param("keyword") String keyword);

}
