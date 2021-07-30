package com.petservice.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponseDto {
    private int statusCode;
    private String message;
    private String userName;
    private String petId;
    private String petName;
    private String petCategory;
    private Long petAge;
    private Double petPrice;
}
