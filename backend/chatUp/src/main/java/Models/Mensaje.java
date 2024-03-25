package Models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private String contenido;
    private Date timestamp;
}
