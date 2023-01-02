package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.sys.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IRoleService {
    Role add(Role newRole);

    Optional<Role> getByName(String name);

    Role getById(Long id);

    List<Role> getAll();

    Role updateById(Long id, Role req);

    Role deleteById(Long id);

    Long count();
}
