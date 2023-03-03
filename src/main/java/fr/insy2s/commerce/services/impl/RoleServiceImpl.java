package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.RoleDto;
import fr.insy2s.commerce.models.Role;
import fr.insy2s.commerce.repositories.IRoleRepository;
import fr.insy2s.commerce.security.ApplicationUserRole;
import fr.insy2s.commerce.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<RoleDto> getAllRole() {
        return roleRepository.findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return modelMapper.map(role, RoleDto.class);
    }




    @Override
    public List<RoleDto> getAllRoleWithoutArchive() {
        return roleRepository.findAllRoleWithoutArchive()
                .stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleDto> getAllArchive() {
        return roleRepository.findAllArchive()
                .stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}
