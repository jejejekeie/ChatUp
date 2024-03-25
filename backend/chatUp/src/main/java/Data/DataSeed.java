package Data;

import Services.ChatService;
import Services.MensajeService;
import Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSeed {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private ChatService chatService;

    /*
    private void seedUsuarios() {
        usuarioService.registroUsuario("Juan Perez", "juan.perez@example.com", "contrasena123");
        usuarioService.registroUsuario("Maria Lopez", "maria.lopez@example.com", "contrasena123");
        usuarioService.registroUsuario("Pedro Rodriguez", "pedro.rodriguez@example.com", "contrasena123");
        usuarioService.registroUsuario("Ana Gomez", "ana.gomez@example.com", "contrasena123");
    }

    private void seedChats(Usuario juan, Usuario maria, Usuario pedro, Usuario ana) {
        // Creación de un conjunto de miembros para un chat
        Set<String> miembrosJuanMaria = new HashSet<>();
        miembrosJuanMaria.add(juan.getId());
        miembrosJuanMaria.add(maria.getId());

        // Crear un chat y obtener el ID del chat creado
        String chatIdJuanMaria = chatService.getChatId(miembrosJuanMaria, true).orElseThrow();

        // Seed de mensajes en el chat Juan-Maria
        Mensaje mensaje = Mensaje.builder()
                .chatId(chatIdJuanMaria)
                .remitenteId(juan.getId())
                .contenido("Hola María, ¿cómo estás?")
                .timestamp(new Date())
                .build();

        mensajeService.save(mensaje);
    }
     */
}
