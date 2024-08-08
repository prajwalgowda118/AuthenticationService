package com.scaler.authenticationservice.Controllers;


import com.scaler.authenticationservice.Dtos.SetUserRolesRequestDto;
import com.scaler.authenticationservice.Dtos.UserDTO;
import com.scaler.authenticationservice.Exception.UserNotFoundException;
import com.scaler.authenticationservice.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("id") Long id) throws UserNotFoundException {

        UserDTO userDTO = userService.getUserDetails(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<UserDTO> setUserRoles(@PathVariable("id") Long id, @RequestBody SetUserRolesRequestDto setUserRolesRequestDto )
    throws UserNotFoundException
    {
            List<Long> roleID= setUserRolesRequestDto.getRoleID();
            UserDTO userDTO=userService.setUserRoles(id,roleID);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

}
