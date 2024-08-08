package com.scaler.authenticationservice.Repository;

import com.scaler.authenticationservice.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  RolesRepository  extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String name);

    Role save(Role role);

    List<Role> findAllByIdIn(List<Long> ids);
}
