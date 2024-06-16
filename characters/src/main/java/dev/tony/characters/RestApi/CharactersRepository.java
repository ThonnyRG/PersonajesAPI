package dev.tony.characters.RestApi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharactersRepository extends MongoRepository<Characters, String>{

}
