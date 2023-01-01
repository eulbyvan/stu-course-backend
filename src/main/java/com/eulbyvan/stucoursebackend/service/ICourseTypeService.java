package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.CourseType;

import java.util.List;
import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface ICourseTypeService {
    List<CourseType> getAll();
    CourseType getById(Long id);
    CourseType add(CourseType courseType);
    CourseType updateById(Long id, CourseType courseType);
    void deleteById(Long id);
    CourseType findByName(String name);

    Long count();
}
