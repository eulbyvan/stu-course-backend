package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.dto.request.EditProfileVM;
import com.eulbyvan.stucoursebackend.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IUserService {
    User add(User user);

    List<User> getAll();

    User getById(Long id);

    Optional<User> getByUsername(String username);

    EditProfileVM editProfile(Long id, EditProfileVM req);

    void deleteById(Long id);

    Long count();
}
