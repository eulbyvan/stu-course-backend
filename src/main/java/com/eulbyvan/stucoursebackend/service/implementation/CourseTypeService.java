package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.model.entity.CourseType;
import com.eulbyvan.stucoursebackend.repo.ICourseTypeRepo;
import com.eulbyvan.stucoursebackend.service.ICourseTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Service
public class CourseTypeService implements ICourseTypeService {
    ICourseTypeRepo courseTypeRepo;

    public CourseTypeService(ICourseTypeRepo courseTypeRepo) {
        this.courseTypeRepo = courseTypeRepo;
    }

    @Override
    public CourseType add(CourseType newCourseType) {
        newCourseType.setName(newCourseType.getName().toUpperCase());
        return courseTypeRepo.save(newCourseType);
    }

    @Override
    public Optional<CourseType> findByName(String name) {
        return courseTypeRepo.findByName(name);
    }

    @Override
    public Long count() {
        return courseTypeRepo.count();
    }
}
