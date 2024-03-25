package Services;

import Models.Mensaje;
import Repositories.MensajeRepository;
import java.util.List;
import java.util.Set;

public class MensajeService {
    private final MensajeRepository repository;
    private final ChatService chatService;

    public MensajeService(MensajeRepository repository, ChatService chatService) {
        this.repository = repository;
        this.chatService = chatService;
    }

    public Mensaje save(Mensaje mensaje) {
        boolean isGroupChat = mensaje.getRemitenteId() == null;
        assert mensaje.getRemitenteId() != null;
        Set<String> miembrosId = new java.util.HashSet<>(Set.of(mensaje.getRemitenteId()));

        miembrosId.add(mensaje.getRemitenteId());

        var chatId = chatService.getChatId(miembrosId, true).orElseThrow(() -> new RuntimeException("Chat no encontrado"));
        mensaje.setChatId(chatId);
        repository.save(mensaje);
        return mensaje;
    }

    public List<Mensaje> findMensajesChat(String chatId) {
        return repository.findByChatId(chatId);
    }
}
