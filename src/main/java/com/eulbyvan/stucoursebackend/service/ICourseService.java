package com.eulbyvan.stucoursebackend.service;

import com.eulbyvan.stucoursebackend.model.entity.Course;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public interface ICourseService {
    List<Course> getAll();

    Course getById(Long id);

    Course add(Course newCourse);

    Course updateById(Long id, Course course);

    void deleteById(Long id);

    Long count();
}
