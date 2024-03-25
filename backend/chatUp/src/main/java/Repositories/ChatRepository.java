package Repositories;

import Models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.Set;

public interface ChatRepository extends MongoRepository<Chat, String> {
    Optional<Chat> findChatBy(Set<String> miembrosId);
}
