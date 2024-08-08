package com.scaler.authenticationservice.Controllers;


import com.scaler.authenticationservice.Dtos.CreateRoleRequestDto;
import com.scaler.authenticationservice.Models.Role;
import com.scaler.authenticationservice.Services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;

    }

    @PostMapping()
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequestDto createRoleRequestDto) {

        Role role = roleService.createRole(createRoleRequestDto.getRoleName());

        return new ResponseEntity<>(role, HttpStatus.OK);

    }
}
