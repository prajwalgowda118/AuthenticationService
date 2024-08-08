package com.scaler.authenticationservice.Repository;

import com.scaler.authenticationservice.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    Session save(Session session);

  //  Optional<Session> findByTokenAndUser_Id(String token, Long userId);

    Optional<Session> findByTokenAndUser_Id(String token, Long userId);



}
