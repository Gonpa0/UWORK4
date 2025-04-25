package pe.edu.upc.s3155_uwork4.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Articulo;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo,Integer> {

}
