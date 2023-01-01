package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.User;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IUserService {
    User add(User user);

    Long count();
}
