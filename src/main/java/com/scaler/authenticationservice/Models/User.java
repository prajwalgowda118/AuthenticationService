package com.scaler.authenticationservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity

public class User extends BaseModel {

    private String email;
    private String password;
    private String phoneNumber;
    @ManyToMany
    private Set<Role> roles=new HashSet<>();


}
