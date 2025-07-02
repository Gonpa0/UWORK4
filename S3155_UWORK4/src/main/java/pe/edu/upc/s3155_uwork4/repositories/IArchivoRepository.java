package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Archivo;

import java.util.List;

@Repository
public interface IArchivoRepository extends JpaRepository<Archivo, Integer> {

    //METODO PARA LISTAR ARCHIVOS POR ID DE ASESORIA REPOSITORY
    List<Archivo> findByAsesoriaIdAsesoria(int idAsesoria);

}