package repositories;

import models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByUsername(String nombre);

    boolean existsByEmail(String email);

    Usuario findByUsername(String nombre);

    void updateUser(String nombre, String email, String hashContrasena, int id);

}
