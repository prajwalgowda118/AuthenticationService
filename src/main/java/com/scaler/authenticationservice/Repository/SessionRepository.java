package com.scaler.authenticationservice.Repository;

import com.scaler.authenticationservice.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {


}
