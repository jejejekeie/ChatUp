package Repositories;

import Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);

    Usuario findByNombre(String nombre);

    void updateUser(String nombre, String email, String hashContrasena, int id);

}
