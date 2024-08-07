package com.scaler.authenticationservice.Dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserSignUpRequestDto {

    private String email;
    private String password;

}
