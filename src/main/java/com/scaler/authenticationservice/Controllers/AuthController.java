package com.scaler.authenticationservice.Controllers;


import com.scaler.authenticationservice.Dtos.*;
import com.scaler.authenticationservice.Models.SessionStatus;
import com.scaler.authenticationservice.Services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")

public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;

    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto)
    {

        String email = userSignUpRequestDto.getEmail();
        String password = userSignUpRequestDto.getPassword();

        UserDTO userDTO= authService.signUp(email,password);

        return new ResponseEntity<>(userDTO,HttpStatus.OK);


    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDto loginRequestDto){

        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

       // UserDTO userDTO=authService.login(email,password);
        return authService.login(email,password);

    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto){

        String token = logoutRequestDto.getToken();
        long userId = logoutRequestDto.getUserId();

        return authService.logoutUser(userId,token);
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateTokenResponseDto> validate(@RequestBody ValidateTokenRequestDto validateTokenRequestDto){

        String token = validateTokenRequestDto.getToken();
        long userId = validateTokenRequestDto.getUserId();

        Optional<UserDTO> userDTO=authService.validate(userId,token);

        if(!userDTO.isPresent()){

            ValidateTokenResponseDto validateTokenResponseDto = new ValidateTokenResponseDto();
            validateTokenResponseDto.setSessionStatus(SessionStatus.INVALID);
            return new ResponseEntity<>(validateTokenResponseDto,HttpStatus.OK);
        }

        ValidateTokenResponseDto validateTokenResponseDto = new ValidateTokenResponseDto();
        validateTokenResponseDto.setUserDto(userDTO.get());
        validateTokenResponseDto.setSessionStatus(SessionStatus.ACTIVE);
        return new ResponseEntity<>(validateTokenResponseDto,HttpStatus.OK);

    }

}
