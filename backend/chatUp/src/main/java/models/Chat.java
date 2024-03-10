package models;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoChat tipo;
    private Timestamp creadoEn;

    @OneToMany(mappedBy = "chat")
    private Set<Mensaje> mensaje;

    @ManyToMany
    @JoinTable(name = "miembros_chat",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Usuario> miembros;

    public enum TipoChat {
        GRUPO, INDIVIDUAL
    }
}
