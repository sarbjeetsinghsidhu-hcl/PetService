package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GenerateTokenDto {
    private String userId;
    private String password;
}
