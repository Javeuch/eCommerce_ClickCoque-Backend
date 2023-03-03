package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.RoleDto;
import fr.insy2s.commerce.models.Role;
import fr.insy2s.commerce.security.ApplicationUserRole;

import java.util.List;

public interface IRoleService {
    List<RoleDto> getAllRole();

    RoleDto findById(Long id);


    List<RoleDto> getAllRoleWithoutArchive();

    List<RoleDto> getAllArchive();

    void deleteRole(Long id);

    Role addRole(Role role);
}
