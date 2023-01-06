package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.model.dto.request.EditProfileReq;
import com.eulbyvan.stucoursebackend.shared.exception.NotFoundException;
import com.eulbyvan.stucoursebackend.model.entity.sys.User;
import com.eulbyvan.stucoursebackend.repo.IUserRepo;
import com.eulbyvan.stucoursebackend.service.IRoleService;
import com.eulbyvan.stucoursebackend.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserService implements IUserService {
    private IUserRepo userRepo;
    private IRoleService roleService;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepo userRepo, IRoleService roleService) {
        super();
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleService = roleService;
    }

    @Override
    public User add(User req) {
        req.setPassword(passwordEncoder.encode(req.getPassword()));
        req.setUsername(req.getUsername().toUpperCase());
        return userRepo.save(req);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public EditProfileReq editProfile(Long id, EditProfileReq req) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        existingUser.setDisplayName(req.getDisplayName());
        existingUser.setUpdatedDate(LocalDateTime.now());

        return req;
    }

    @Override
    public User deleteById(Long id) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        existingUser.setIsActive(0);
        existingUser.setIsDeleted(1);
        existingUser.setDeletedDate(LocalDateTime.now());

        return userRepo.save(existingUser);
    }

    @Override
    public Long count() {
        return userRepo.count();
    }
}
