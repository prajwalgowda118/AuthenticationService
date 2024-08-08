package com.scaler.authenticationservice.Services;


import com.scaler.authenticationservice.Dtos.UserDTO;
import com.scaler.authenticationservice.Exception.UserNotFoundException;
import com.scaler.authenticationservice.Models.Role;
import com.scaler.authenticationservice.Models.User;
import com.scaler.authenticationservice.Repository.RolesRepository;
import com.scaler.authenticationservice.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    public UserService(UserRepository userRepository, RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    public UserDTO getUserDetails(Long userId) {

        Optional<User> user = userRepository.findById(Math.toIntExact(userId));

        if (!user.isPresent()) {
            throw new UserNotFoundException("user not found");
        }


        UserDTO userDTO = new UserDTO();

        return userDTO.from(user.get());

    }

    public UserDTO setUserRoles(Long userId, List<Long> roles) {
        Optional<User> optionalUser = userRepository.findById(Math.toIntExact(userId));
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("user not found");
        }
        List<Role> rolesList = rolesRepository.findAllByIdIn(roles);

        User user= optionalUser.get();

        user.setRoles(Set.copyOf(rolesList));

        userRepository.save(user);

        return UserDTO.from(user);


    }
}

