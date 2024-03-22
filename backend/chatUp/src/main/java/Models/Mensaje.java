package Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Mensaje {
    @Id
    private String id;
    private String chatId;
    private String remitenteId;
    private String tipoChat;
    private String contenido;
    private Date timestamp;
}
