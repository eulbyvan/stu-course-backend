package com.eulbyvan.stucoursebackend.repo;

import com.eulbyvan.stucoursebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
