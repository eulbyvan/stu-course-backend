package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.Role;
import com.eulbyvan.stucoursebackend.repo.IRoleRepo;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Service
public class RoleService implements IRoleService{
    IRoleRepo roleRepo;

    public RoleService(IRoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role add(Role newRole) {
        return roleRepo.save(newRole);
    }

    @Override
    public Long count() {
        return roleRepo.count();
    }
}
