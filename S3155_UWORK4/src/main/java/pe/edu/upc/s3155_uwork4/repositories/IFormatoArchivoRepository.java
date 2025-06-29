package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;

import java.util.List;

@Repository
public interface IFormatoArchivoRepository extends JpaRepository<FormatoArchivo, Integer> {

    //QUERY
    @Query("SELECT me FROM FormatoArchivo me WHERE me.extension = :extension")
    List<FormatoArchivo> buscarArchivoPorExtension(@Param("extension") String extension);


}
