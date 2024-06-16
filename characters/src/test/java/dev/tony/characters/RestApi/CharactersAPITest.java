package dev.tony.characters.RestApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Sort;

public class CharactersAPITest {

    @Mock
    private CharactersRepository charactersRepository;

    @InjectMocks
    private CharactersServiceIMPL charactersServiceIMPL;

    private Characters characters;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        characters = new Characters();
        characters.setName("Tony");
        characters.setSurname("Stark");
        characters.setAlias("Iron Man");
        characters.setAge(45);
        characters.setSex("M");
        characters.setComics(new String[]{"The Invincible Iron Man", "Avengers"});
        characters.setData("{\"weapon\": [\"suit\"]}");
        characters.setImage("https://media.wired.com/photos/59344c46bef1fc4e58f92253/master/w_2560%2Cc_limit/im_large_660.jpg");
    }

    @Test
    void testAddCharacter() throws NotFoundException {
        when(charactersRepository.save(characters)).thenReturn(characters);
        Characters savedCharacter = charactersServiceIMPL.addCharacter(characters);
        assertNotNull(savedCharacter);
        assertEquals("Tony", savedCharacter.getName());
    }

    @Test
    void testDeleteAllCharacters() {
        charactersServiceIMPL.deleteAllCharacters();
        verify(charactersRepository).deleteAll();
    }

    @Test
    void testDeleteCharacterById() throws NotFoundException {
        String id = "666efcafd170851db81402a9";
        charactersServiceIMPL.deleteCharacterById(id);
        verify(charactersRepository).deleteById(id);
    }

    @Test
    void testFindCharacterById() throws NotFoundException {
        String id = "666efcafd170851db81402a9";
        when(charactersRepository.findById(id)).thenReturn(Optional.of(characters));
        Optional<Characters> foundCharacter = charactersServiceIMPL.findCharacterById(id);
        assertNotNull(foundCharacter);
        assertEquals("Iron Man", foundCharacter.get().getAlias());
    }

    @Test
    void testGetAllCharacters() {
        when(charactersRepository.findAll()).thenReturn(List.of(characters));
        List<Characters> allCharacters = charactersServiceIMPL.getAllCharacters();
        assertNotNull(allCharacters);
    }

    @Test
    void testGetAllCharactersSort() throws NotFoundException {
        String id = "666efcafd170851db81402a9";
        when(charactersRepository.findById(id)).thenReturn(Optional.of(characters));
        Optional<Characters> foundCharacter = charactersServiceIMPL.findCharacterById(id);
        assertNotNull(foundCharacter);
        assertEquals("Iron Man", foundCharacter.get().getAlias());
    }

    @Test
    void testUpdateCharacter() {
        Characters updatedCharacter = new Characters();
        updatedCharacter.setName("Tony Updated");
        updatedCharacter.setSurname("Stark Updated");
        updatedCharacter.setAlias("Iron Man Updated");
        updatedCharacter.setAge(46);
        updatedCharacter.setSex("M");
        updatedCharacter.setComics(new String[]{"The New Invincible Iron Man", "New Avengers"});
        updatedCharacter.setData("{\"newWeapon\": [\"newSuit\"]}");
        updatedCharacter.setImage("https://new.image.url/ironman.jpg");

        String id = "666efcafd170851db81402a9";
        when(charactersRepository.findById(id)).thenReturn(Optional.of(characters));
        when(charactersRepository.save(any(Characters.class))).thenReturn(updatedCharacter);

        Characters result = charactersServiceIMPL.updateCharacter(updatedCharacter);
        
        assertNotNull(result);
        assertEquals("Tony Updated", result.getName());
    }

    @Test
    void testDeleteCharacterByIdNotFound() {
        String id = "nonExistingId";
        when(charactersRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            charactersServiceIMPL.deleteCharacterById(id);
        });

        assertEquals("Personaje no encontrado en la base de datos con ID: " + id, exception.getMessage());
    }

    @Test
    void testFindCharacterByIdNotFound() {
        String id = "nonExistingId";
        when(charactersRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            charactersServiceIMPL.findCharacterById(id);
        });

        assertEquals("Personaje no encontrado en la base de datos con ID: " + id, exception.getMessage());
    }


    
}
