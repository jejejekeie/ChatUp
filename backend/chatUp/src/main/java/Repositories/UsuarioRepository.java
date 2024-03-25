package Repositories;

import Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);

    Usuario findByNombre(String nombre);

    void updateUser(String nombre, String email, String hashContrasena, int id);
}
