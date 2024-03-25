package Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Usuario {
    @Id
    private String id;
    private String nombre;
    @Indexed(unique = true)
    private String email;
    private String hashContrasena;
    private String fotoPerfil;
    private String estado;
    private Date ultimoAcceso;
    private Set<String> contactosId;
}
