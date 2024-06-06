package dev.tony.characters.RestApi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String name;
    private String surname;
    private String age;
    private String sex; 
    private String[] comics;
    private String data;
}
