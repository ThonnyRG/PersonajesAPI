package dev.tony.characters.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return charactersRepository.save(character);
    }

    public Characters updateCharacter(Characters character) {
        return charactersRepository.save(character);
    }

    public Optional<Characters> findCharacterById(String id) {
        return charactersRepository.findById(id);
    }

    public void deleteCharacterById(String id) {
        charactersRepository.deleteById(id);
    }

    public void deleteAllCharacters() {
        charactersRepository.deleteAll();
    }
}
