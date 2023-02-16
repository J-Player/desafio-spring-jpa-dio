package br.com.example.models.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Builder
public class ReviewDTO {

    @NonNull
    private Long gameId;
    @NonNull
    private Long userId;
    @NotBlank
    private String comment;
    @NotNull
    private Boolean recommend;
    private Instant date;
    private Instant dateEdit;

}
