package models;

import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;
    private boolean leido;
    private Timestamp timestamp;

    public enum TipoNotificacion {
        MENSAJE, INVITACION
    }

}

