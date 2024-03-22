package Models;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {
    private String id;
    private String remitenteId;
    private String destinatarioId;
    private String contenido;
}
