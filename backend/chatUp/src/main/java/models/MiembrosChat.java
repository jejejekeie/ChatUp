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
public class MiembrosChat {
    @Id
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Timestamp unidoEn;
}
