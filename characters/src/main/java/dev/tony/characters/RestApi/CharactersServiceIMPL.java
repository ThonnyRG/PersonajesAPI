package dev.tony.characters.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CharactersServiceIMPL {

    @Autowired
    private CharactersRepository repository;

    public Flux<Characters> allChatacters(){
        return this.repository.findAll();
    }

    public Mono<Characters> addChatacters(Characters characters){
        return this.repository.save(characters);
    }

    public Mono<Characters> updateChatacters(Characters characters){
        return this.repository.save(characters);

    }    public Mono<Characters> findChatacters(String id){
        return this.repository.findById(id);


    }    public Mono<Void> deleteChatacters(String id){
        return this.repository.deleteById(id);

    }    public Mono<Void> deleteAllChatacters(){
        return this.repository.deleteAll();
    }


}
