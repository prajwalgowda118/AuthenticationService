package com.scaler.authenticationservice.Dtos;

import com.scaler.authenticationservice.Models.Role;
import com.scaler.authenticationservice.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class UserDTO {

    private String email;
    private Set<Role> roles;


    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }
}
