package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.model.dto.response.NotFoundException;
import com.eulbyvan.stucoursebackend.model.entity.sys.Role;
import com.eulbyvan.stucoursebackend.repo.IRoleRepo;
import com.eulbyvan.stucoursebackend.service.IRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Service
public class RoleService implements IRoleService {
    IRoleRepo roleRepo;

    public RoleService(IRoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role add(Role newRole) {
        newRole.setName(newRole.getName().toUpperCase());
        return roleRepo.save(newRole);
    }

    @Override
    public Optional<Role> getByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public Role getById(Long id) {
        return roleRepo.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role updateById(Long id, Role req) {
        Role existingRole = roleRepo.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));

        existingRole.setName(req.getName());
        existingRole.setUpdatedDate(LocalDateTime.now());

        return roleRepo.save(existingRole);
    }

    @Override
    public Role deleteById(Long id) {
        Role existingRole = roleRepo.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));

        existingRole.setIsActive(0);
        existingRole.setIsDeleted(1);
        existingRole.setDeletedDate(LocalDateTime.now());

        return roleRepo.save(existingRole);
    }

    @Override
    public Long count() {
        return roleRepo.count();
    }
}
