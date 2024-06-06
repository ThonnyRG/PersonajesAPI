package dev.tony.characters.RestApi;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CharactersRepository extends ReactiveMongoRepository<Characters, String>{

}
