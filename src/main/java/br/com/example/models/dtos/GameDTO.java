package br.com.example.models.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GameDTO {

    @NotBlank(message = "Game name is required.")
    private String name;

}
