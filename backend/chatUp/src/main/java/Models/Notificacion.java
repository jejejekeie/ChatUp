package Models;

import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {
    @Id
    private String id;
    private String chatId;
    private String remitenteId;
    private Date tiemstamp;
    private String mensaje;
}
