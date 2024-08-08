package com.scaler.authenticationservice.Services;

import com.scaler.authenticationservice.Models.Role;
import com.scaler.authenticationservice.Repository.RolesRepository;
import org.springframework.stereotype.Service;

@Service

public class RoleService {

    private RolesRepository rolesRepository;
    public RoleService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;

    }

    public Role createRole(String roleName) {

        Role roleObj = new Role();
        roleObj.setRoleName(roleName);

        return rolesRepository.save(roleObj);

    }
}
