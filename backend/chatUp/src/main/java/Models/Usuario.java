package Models;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String hashContrasena;
    private String fotoPerfil;
    private String estado;
    private Date ultimoAcceso;
    private Set<String> contactoIds;
}
