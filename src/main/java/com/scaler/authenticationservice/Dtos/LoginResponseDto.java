package com.scaler.authenticationservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginResponseDto {

    private String token;
    private String email;
}
