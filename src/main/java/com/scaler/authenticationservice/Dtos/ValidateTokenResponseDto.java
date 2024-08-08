package com.scaler.authenticationservice.Dtos;


import com.scaler.authenticationservice.Models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDto {

    private UserDTO userDto;
    private SessionStatus sessionStatus;

}
