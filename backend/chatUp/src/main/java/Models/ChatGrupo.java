package Models;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ChatGrupo {
    @Id
    private String id;
    private String nombre;
    private Set<String> miembroIds;
}
