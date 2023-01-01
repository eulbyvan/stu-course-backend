package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.CourseType;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface ICourseTypeService {
    CourseType add(CourseType newCourseType);
    Optional<CourseType> findByName(String name);

    Long count();
}
