package com.eulbyvan.stucoursebackend.repo;

import com.eulbyvan.stucoursebackend.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface ICourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByTitle(String title);
}
