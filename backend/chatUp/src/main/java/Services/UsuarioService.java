package Services;

import Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registroUsuario(String nombre, String email, String contrasena) {
        if (usuarioRepository.existsByNombre(nombre) || usuarioRepository.existsByEmail(email)) {
            throw new IllegalStateException("Username or email already exists.");
        }
        String hashedPassword = passwordEncoder.encode(contrasena);
        Usuario newUser = new Usuario();
        newUser.setNombre(nombre);
        newUser.setEmail(email);
        newUser.setHashContrasena(hashedPassword);
        usuarioRepository.save(newUser);
    }

    public void loginUsuario(String nombre, String contrasena) {
        Usuario user = usuarioRepository.findByNombre(nombre);
        if (user == null) {
            throw new IllegalStateException("Usuario no encontrado.");
        }
        if (!passwordEncoder.matches(contrasena, user.getHashContrasena())) {
            throw new IllegalStateException("Contraseña incorrecta.");
        }
    }

    public void getUsuario(String username) {
        usuarioRepository.findByNombre(username);
    }

    public void updateUser(String username, String email, String password, int id) {
        usuarioRepository.updateUser(username, email, password, id);
    }

    public void deleteUser(int id) {
        usuarioRepository.deleteById((long) id);
    }
}
