package Services;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import Repositories.ChatRepository;
import Models.Chat;

public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Optional<String> getChatId(
            Set<String> miembrosId,
            boolean createNewChatIfNotExists
    ) {
        return chatRepository
                .findChatBy(miembrosId)
                .map(Chat::getChatId)
                .or(() -> {
                    if(createNewChatIfNotExists) {
                        var chatId = createChatId(miembrosId);
                        return Optional.of(chatId);
                    }

                    return  Optional.empty();
                });
    }

    private String createChatId(Set<String> miembrosIds) {
        var chatId = String.format("%s_%s", miembrosIds.toArray());

        Chat senderRecipient = Chat
                .builder()
                .chatId(chatId)
                .miembrosId(miembrosIds)
                .build();

        Chat recipientSender = Chat
                .builder()
                .chatId(chatId)
                .miembrosId(Collections.singleton(miembrosIds.toArray()[1].toString()))
                .build();

        chatRepository.save(senderRecipient);
        chatRepository.save(recipientSender);

        return chatId;
    }
}
