package br.com.example.mappers;

import br.com.example.models.Review;
import br.com.example.models.dtos.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ReviewMapper {

    public static final ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "game", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "dateEdit", ignore = true)
    @Mapping(target = "comment", source = "dto.comment")
    @Mapping(target = "recommend", source = "dto.recommend")
    public abstract Review toReview(ReviewDTO dto);

}
