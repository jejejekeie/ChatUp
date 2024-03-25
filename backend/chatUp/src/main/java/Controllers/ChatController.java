package Controllers;

import Models.Mensaje;
import Services.MensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MensajeService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(Mensaje chatMessage) {
        Mensaje msjGuardado = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRemitenteId(), "/queue/messages",
                msjGuardado
        );
    }

    @GetMapping("/mensajes/{chatId}")
    public ResponseEntity<List<Mensaje>> getMensajesChat(
            @PathVariable String chatId
    ) {
        return ResponseEntity.ok(chatMessageService.findMensajesChat(chatId));
    }
}
