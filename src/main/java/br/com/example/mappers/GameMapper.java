package br.com.example.mappers;

import br.com.example.models.Game;
import br.com.example.models.dtos.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class GameMapper {

    public static final GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    public abstract Game toGame(GameDTO dto);

}
