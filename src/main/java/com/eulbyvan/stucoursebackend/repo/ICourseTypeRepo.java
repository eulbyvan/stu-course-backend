package com.eulbyvan.stucoursebackend.repo;

import com.eulbyvan.stucoursebackend.model.entity.mst.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface ICourseTypeRepo extends JpaRepository<CourseType, Long> {
    Optional<CourseType> findByName(String name);
}
