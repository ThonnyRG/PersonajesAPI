package dev.tony.characters.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CharacterController {
    @Autowired
    private CharactersServiceIMPL chsimpl;

    @GetMapping("/allCharacters")
    public ResponseEntity<Flux<Characters>> allCharacters(){
        Flux<Characters> flux = this.chsimpl.allChatacters();
        return new ResponseEntity<>(flux, HttpStatus.OK);
    }

    @PostMapping("/addCharacters")
    public ResponseEntity<Mono<Characters>> addCharacters(@RequestBody Characters characters){
        Mono<Characters> charMono= this.chsimpl.addChatacters(characters);
        return new ResponseEntity<>(charMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateCharacters")
    public ResponseEntity<Mono<Characters>> updateCharacters(@RequestBody Characters characters){
        Mono<Characters> charMono= this.chsimpl.updateChatacters(characters);
        return new ResponseEntity<>(charMono, HttpStatus.OK);
    }

    @GetMapping("/findCharacters/{id}")
    public ResponseEntity<Mono<Characters>> findCharacters(@PathVariable String id){
        Mono<Characters> charMono= this.chsimpl.findChatacters(id);
        return new ResponseEntity<>(charMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCharacters/{id}")
    public ResponseEntity<Mono<Void>> deleteCharacters(@PathVariable String id){
        Mono<Void> charMono= this.chsimpl.deleteChatacters(id);
        return new ResponseEntity<>(charMono, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Mono<Void>> deleteCharacters(){
        Mono<Void> charMono= this.chsimpl.deleteAllChatacters();
        return new ResponseEntity<>(charMono, HttpStatus.NO_CONTENT);
    }
}
