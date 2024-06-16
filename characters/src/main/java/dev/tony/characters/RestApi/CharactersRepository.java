package dev.tony.characters.RestApi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends MongoRepository<Characters, String>{

}
