package com.petservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthToken {

    private String token;
    private String email;
}
