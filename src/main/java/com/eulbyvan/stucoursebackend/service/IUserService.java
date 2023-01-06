package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.dto.request.EditProfileReq;
import com.eulbyvan.stucoursebackend.model.entity.sys.User;

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

    EditProfileReq editProfile(Long id, EditProfileReq req);

    User deleteById(Long id);

    Long count();
}
