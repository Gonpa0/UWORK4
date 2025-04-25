package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
@Repository
public interface IAsesoriaRepository extends JpaRepository<Asesoria, Integer> {

}
