package dev.tony.characters.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

    public Characters addCharacter(Characters character) throws NotFoundException{
        if (character == null || StringUtils.isBlank(character.getAlias())) {
            throw new NotFoundException();
        }        
        return charactersRepository.save(character);
    }

    public Characters updateCharacter(Characters character) {
        return charactersRepository.save(character);
    }

    public Optional<Characters> findCharacterById(String id) throws NotFoundException {
        if (StringUtils.isBlank(id)) {
            throw new NotFoundException();
        }
        Optional<Characters> character = charactersRepository.findById(id);
        if (!character.isPresent()) {
            throw new NotFoundException();
        }
        return charactersRepository.findById(id);
    }

    public void deleteCharacterById(String id) throws NotFoundException {
        if (StringUtils.isBlank(id)) {
            throw new NotFoundException();
        }
        charactersRepository.deleteById(id);
    }

    public void deleteAllCharacters() {
        charactersRepository.deleteAll();
    }
}
