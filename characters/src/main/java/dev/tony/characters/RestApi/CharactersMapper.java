package dev.tony.characters.RestApi;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CharactersMapper {

    CharactersMapper INSTANCE = Mappers.getMapper(CharactersMapper.class);

    Characters characterToCharacterDTO(Character character);

    Character characterDTOToCharacter(Characters characterDTO);

    List<Characters> charactersToCharacterDTOs(List<Character> characters);

    List<Character> characterDTOsToCharacters(List<Characters> characterDTOs);
}
