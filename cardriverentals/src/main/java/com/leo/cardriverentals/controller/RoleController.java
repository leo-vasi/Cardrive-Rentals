package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.PaymentMethod;
import com.leo.cardriverentals.model.Role;
import com.leo.cardriverentals.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController (RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(roles);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.getRoleById(id);
        if (role.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(role.get());
        }
    }

    @PostMapping
    public ResponseEntity<Role> createRole (@Valid @RequestBody Role role) {
        Role createRole = roleService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRole);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        Optional<Role> existingRole = roleService.getRoleById(id);
        if (existingRole.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Role updateRole = roleService.updateRole(id, role);
            return ResponseEntity.ok(updateRole);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole (@PathVariable Long id) {
        if (roleService.getRoleById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            roleService.deleteRole(id);
            return ResponseEntity.noContent().build();
        }
    }
}
