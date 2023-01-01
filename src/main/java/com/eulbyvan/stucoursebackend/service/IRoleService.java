package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.Role;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IRoleService {
    Role add(Role newRole);

    Long count();
}
