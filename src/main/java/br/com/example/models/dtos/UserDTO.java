package br.com.example.models.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDTO {

    @NotBlank(message = "User name is required.")
    private String name;

}
