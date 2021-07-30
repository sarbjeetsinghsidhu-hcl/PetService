package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EditPetDTO {


    private String petId;

    private String petName;

    private String petCategory;

    private Long petAge;

    private String petAvailibility;

    private Double petPrice;

}
