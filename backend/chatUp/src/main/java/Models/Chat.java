package Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.lang.annotation.Documented;
import java.security.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Chat {
    @Id
    private String id;
    private String chatId;
    private String nombre;
    private Set<String> miembroIds;
}
