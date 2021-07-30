package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetDetailsResponseDTO {

    private int statusCode;
    private String message;
    private PetDetailsDTO petDetailsDTO;

}
