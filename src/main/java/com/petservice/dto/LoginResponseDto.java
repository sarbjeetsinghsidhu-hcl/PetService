package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponseDto {
    private int statusCode;
    private String message;
    private String customerName;
}
