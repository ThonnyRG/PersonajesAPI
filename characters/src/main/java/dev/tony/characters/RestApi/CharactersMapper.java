package dev.tony.characters.RestApi;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharactersMapper {
    CharactersMapper INSTANCE = Mappers.getMapper(CharactersMapper.class);

    Characters toDTO(Characters characters);
    Characters toEntity(Characters charactersDTO);
}