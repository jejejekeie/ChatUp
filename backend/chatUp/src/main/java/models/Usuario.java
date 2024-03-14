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
public class Usuario {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hashContrasena;

    @Column()
    private String fotoPerfil;

    @Column()
    private String estado;

    @Column(nullable = false)
    private Timestamp ultimoAcceso;

    @ManyToMany
    @JoinTable(name = "contactos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "contacto_id"))
    private Set<Usuario> contactos;
}

