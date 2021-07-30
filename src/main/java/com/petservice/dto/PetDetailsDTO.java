package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetDetailsDTO {

    private String petId;

    private String petName;

    private String petCategory;

    private Long petAge;

    private int petAvailibility;

    private Double petPrice;

    /**
     *
     */
    public PetDetailsDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param petId
     * @param petName
     * @param petCategory
     * @param petAge
     * @param petAvailibility
     * @param petPrice
     */
    public PetDetailsDTO(String petId, String petName, String petCategory, Long petAge, int petAvailibility,
                         Double petPrice) {
        super();
        this.petId = petId;
        this.petName = petName;
        this.petCategory = petCategory;
        this.petAge = petAge;
        this.petAvailibility = petAvailibility;
        this.petPrice = petPrice;
    }


    @Override
    public String toString() {
        return "PetDetailsDTO [petId=" + petId + ", petName=" + petName + ", petCategory=" + petCategory + ", petAge="
                + petAge + ", petAvailibility=" + petAvailibility + ", petPrice=" + petPrice + "]";
    }
}