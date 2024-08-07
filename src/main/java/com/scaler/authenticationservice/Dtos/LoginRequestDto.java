package com.scaler.authenticationservice.Dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequestDto {

    private String email;
    private String password;

}
