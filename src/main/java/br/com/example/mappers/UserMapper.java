package br.com.example.mappers;

import br.com.example.models.User;
import br.com.example.models.dtos.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "games", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    public abstract User toUser(UserDTO dto);

}
