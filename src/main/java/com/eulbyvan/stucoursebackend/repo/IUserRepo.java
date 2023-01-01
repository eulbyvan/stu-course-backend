package com.eulbyvan.stucoursebackend.repo;

import com.eulbyvan.stucoursebackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface IUserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
