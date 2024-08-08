package com.scaler.authenticationservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class Session extends BaseModel {

    private Date sessionDate;
    private String ipAddress;
    private SessionStatus sessionStatus;
    @ManyToOne
    private User user;
    private String token;


}
