package Controllers;

import org.springframework.web.bind.annotation.*;
import Services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioService usuarioService;

    @PostMapping("/registroUsuario")
    public void registroUsuario(String nombre, String email, String hashContrasena) {
        usuarioService.registroUsuario(nombre, email, hashContrasena);
    }

    @GetMapping("/loginUsuario")
    public void loginUsuario(String nombre, String hashContrasena) {
        usuarioService.loginUsuario(nombre, hashContrasena);
    }

    @GetMapping("/getUsuario")
    public void getUser(String nombre) {
        usuarioService.getUsuario(nombre);
    }

    @PutMapping("/updateUsuario")
    public void updateUser(String nombre, String email, String hashContrasena, int id) {
        usuarioService.updateUser(nombre, email, hashContrasena, id);
    }

    @DeleteMapping("/deleteUsuario")
    public void deleteUser(int id) {
        usuarioService.deleteUser(id);
    }
}
