package Repositories;

import Models.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MensajeRepository extends MongoRepository<Mensaje, String> {
    List<Mensaje> findByChatId(String chatId);
}
