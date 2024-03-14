package models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Mensajes")
public class Mensaje {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chatId;

    @ManyToOne
    @JoinColumn(name = "remitente_id")
    private Usuario remitente;

    private String contenido;

    private String tipoContenido;

    private Timestamp timestamp;
}
