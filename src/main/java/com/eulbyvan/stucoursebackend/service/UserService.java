package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.User;
import com.eulbyvan.stucoursebackend.repo.IUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Service
public class UserService implements IUserService{
    private IUserRepo userRepo;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepo userRepo) {
        super();
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Long count() {
        return userRepo.count();
    }
}
