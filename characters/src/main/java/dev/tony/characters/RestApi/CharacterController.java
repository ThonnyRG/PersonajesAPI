package dev.tony.characters.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharactersServiceIMPL chsimpl;

    @Autowired
    private CharactersMapper mapper;
    
    @GetMapping("/allCharacters")
    public ResponseEntity<List<Characters>> getAllCharacters() {
        List<Characters> characters = chsimpl.getAllCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
    @PostMapping("/addCharacters")
    public ResponseEntity<Characters> addCharacter(@RequestBody Characters character) {
        Characters newCharacter = chsimpl.addCharacter(character);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    @PutMapping("/updateCharacters")
    public ResponseEntity<Characters> updateCharacter(@RequestBody Characters character) {
        Characters updatedCharacter = chsimpl.updateCharacter(character);
        return new ResponseEntity<>(updatedCharacter, HttpStatus.OK);
    }

    @GetMapping("/findCharacters/{id}")
    public ResponseEntity<Optional<Characters>> findCharacterById(@PathVariable String id) {
        Optional<Characters> character = chsimpl.findCharacterById(id);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCharacters/{id}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable String id) {
        chsimpl.deleteCharacterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllCharacters() {
        chsimpl.deleteAllCharacters();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
