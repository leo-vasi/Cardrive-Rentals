package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Role;
import com.leo.cardriverentals.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole (Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role role) {
        Role existingRole = roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role Not Found"));
        existingRole.setRoleName(role.getRoleName());
        return roleRepository.save(existingRole);
    }

    public void deleteRole (Long id) {
        roleRepository.deleteById(id);
    }
}
