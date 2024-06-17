package dev.tony.characters.RestApi;

import dev.tony.characters.exceptions.CharacterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import java.util.Optional;

@Service
public class CharactersServiceIMPL {

    @Autowired
    private CharactersRepository charactersRepository;

    public List<Characters> getAllCharacters() {
        return charactersRepository.findAll();
    }

    public Characters addCharacter(Characters character) {
        if (character == null || StringUtils.isBlank(character.getAlias())) {
            throw new CharacterNotFoundException("Character alias is required");
        }        
        return charactersRepository.save(character);
    }

    public Characters updateCharacter(Characters character) {
        return charactersRepository.save(character);
    }

    public Optional<Characters> findCharacterById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new CharacterNotFoundException("Character ID is required");
        }
        Optional<Characters> character = charactersRepository.findById(id);
        if (!character.isPresent()) {
            throw new CharacterNotFoundException("Character not found with ID: " + id);
        }
        return character;
    }

    public void deleteCharacterById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new CharacterNotFoundException("Character ID is required");
        }
        charactersRepository.deleteById(id);
    }

    public void deleteAllCharacters() {
        charactersRepository.deleteAll();
    }
}
