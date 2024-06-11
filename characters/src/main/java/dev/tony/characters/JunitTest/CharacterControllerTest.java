package dev.tony.characters.JunitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import javax.management.MXBean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import dev.tony.characters.RestApi.Characters;
import dev.tony.characters.RestApi.CharactersServiceIMPL;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Test
public class CharacterControllerTest {

    @Autowired
    private WebClient webTestClient;

    @MXBean
    private CharactersServiceIMPL charactersServiceIMPL;

    private Characters character;

    @BeforeEach
    public void setUp() {
        character = new Characters("1", "Tony", "Stark", "Iron Man", "45", "Male", new String[] {"Marvel"}, "data", "image");
    }

    @Test
    public void testAllCharacters() {
        Flux<Characters> characterFlux = Flux.just(character);

        when(charactersServiceIMPL.allChatacters()).thenReturn(characterFlux);

        webTestClient.get().uri("/api/allCharacters")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Characters.class)
                .consumeWith(response -> {
                    var characters = response.getResponseBody();
                    assertNotNull(characters);
                    assertEquals(1, characters.size());
                    assertEquals("Tony", characters.get(0).getName());
                });
    }

    @Test
    public void testAddCharacter() {
        when(charactersServiceIMPL.addChatacters(character)).thenReturn(Mono.just(character));

        webTestClient.post().uri("/api/addCharacters")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(character)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Characters.class)
                .consumeWith(response -> {
                    var returnedCharacter = response.getResponseBody();
                    assertNotNull(returnedCharacter);
                    assertEquals("Tony", returnedCharacter.getName());
                });
    }

}