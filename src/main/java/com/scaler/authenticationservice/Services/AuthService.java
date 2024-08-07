package com.scaler.authenticationservice.Services;

import com.scaler.authenticationservice.Dtos.UserDTO;
import com.scaler.authenticationservice.Exception.UserAlreadyExistException;
import com.scaler.authenticationservice.Exception.UserNotFoundException;
import com.scaler.authenticationservice.Models.Session;
import com.scaler.authenticationservice.Models.SessionStatus;
import com.scaler.authenticationservice.Models.User;
import com.scaler.authenticationservice.Repository.SessionRepository;
import com.scaler.authenticationservice.Repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Optional;

@Service

public class AuthService {

    private final UserRepository userRepository;
    private SessionRepository sessionRepository;

    public AuthService(UserRepository userRepository,SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public UserDTO signUp(String email, String password) throws UserAlreadyExistException {

        UserDTO userDTO = new UserDTO();

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            throw new UserAlreadyExistException("User Already Exist");
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.save(newUser);

        return UserDTO.from(newUser);
    }

    public ResponseEntity<UserDTO> login(String email, String password) throws UserNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {

            throw new UserNotFoundException(user.get().getEmail()+" is not exist");
        }

        String token= RandomStringUtils.randomAscii(20);

        MultiValueMapAdapter<String,String> header= new MultiValueMapAdapter<>(new HashMap<>());

        header.add("token", token);

        Session session= new Session();
        session.setToken(token);
        session.setUser(user.get());
        session.setSessionStatus(SessionStatus.ACTIVE);

        sessionRepository.save(session);

        UserDTO userDTO =UserDTO.from(user.get());


        ResponseEntity<UserDTO> response=new ResponseEntity<>(
                userDTO,
                header,
                HttpStatus.OK
        );



    }
}
