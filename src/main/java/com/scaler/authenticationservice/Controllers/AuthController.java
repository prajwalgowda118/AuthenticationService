package com.scaler.authenticationservice.Controllers;


import com.scaler.authenticationservice.Dtos.LoginRequestDto;
import com.scaler.authenticationservice.Dtos.LoginResponseDto;
import com.scaler.authenticationservice.Dtos.UserDTO;
import com.scaler.authenticationservice.Dtos.UserSignUpRequestDto;
import com.scaler.authenticationservice.Services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
