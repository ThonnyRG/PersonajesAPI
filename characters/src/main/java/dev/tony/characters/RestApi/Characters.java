package dev.tony.characters.RestApi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "characters")
public class Characters {
    @Id
    private String id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Surname is required")
    private String surname;

    private String alias;

    @NotNull(message = "Age is required")
    private Integer age; 

    @NotEmpty(message = "Sex is required")
    private String sex;

    private String[] comics;
    private String data;
    private String image;
}
