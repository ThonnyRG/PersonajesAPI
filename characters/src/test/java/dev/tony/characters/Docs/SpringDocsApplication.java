package dev.tony.characters.Docs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.tony.characters.RestApi.Characters;
import dev.tony.characters.RestApi.CharactersServiceIMPL;

@SpringBootApplication
@RestController
public class SpringDocsApplication {
    @Autowired
    private CharactersServiceIMPL charactersServiceIMPL;

    @PostMapping("/addCharacters")
    public Characters addCharacter(@RequestBody Characters character) throws NotFoundException {
        return charactersServiceIMPL.addCharacter(character);
    }

    @GetMapping("/allCharacters")
    public List<Characters> getAllCharacters() {
        return charactersServiceIMPL.getAllCharacters();
    }
        public static void main(String[] args) {
        SpringApplication.run(SpringDocsApplication.class, args);
    }
}
