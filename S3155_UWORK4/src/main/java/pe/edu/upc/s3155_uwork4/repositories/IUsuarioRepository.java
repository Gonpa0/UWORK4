package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String nombreUsuario);
    @Query(value="SELECT \n" +
            "  u.id_usuario,\n" +
            "  u.username,\n" +
            "  u.correo,\n" +
            "  u.ciclo,\n" +
            "  u.puntos,\n" +
            "  u.carrera,\n" +
            "  u.centro_de_estudios,\n" +
            "  u.id_rol,\n" +
            "  u.estado\n" +
            "FROM usuario u;", nativeQuery = true)
    public List<String[]> ListarUsernameSinPassword();
}
