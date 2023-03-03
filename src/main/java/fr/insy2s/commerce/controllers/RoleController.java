package fr.insy2s.commerce.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insy2s.commerce.dtos.AccountDto;
import fr.insy2s.commerce.dtos.RoleDto;
import fr.insy2s.commerce.models.Role;
import fr.insy2s.commerce.services.impl.AccountServiceImpl;
import fr.insy2s.commerce.services.impl.RoleServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class RoleController {
    private final RoleServiceImpl roleService;

    private final AccountServiceImpl accountService;

    @GetMapping("/role/all")
    public List<RoleDto> getAllRole() {
        return roleService.getAllRole();
    }

    @GetMapping("/role/detail/{id}")
    public RoleDto role(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @GetMapping("/role/allArchive")
    public List<RoleDto> getAllRoleWithoutArchive() {
        return roleService.getAllRoleWithoutArchive();
    }

    @GetMapping("/role/archiveAll")
    public List<RoleDto> getAllArchive() {
        return roleService.getAllArchive();
    }

    @PostMapping("/role/add")
    public Role addRole(@Validated Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping("/role/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    /*@PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        IAccountService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }*/




}


