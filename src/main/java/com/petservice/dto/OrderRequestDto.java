package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderRequestDto {
    private String userId;
    private String petId;
}
