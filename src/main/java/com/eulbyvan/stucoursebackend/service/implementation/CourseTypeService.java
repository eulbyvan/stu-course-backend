package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.model.dto.response.NotFoundException;
import com.eulbyvan.stucoursebackend.model.entity.CourseType;
import com.eulbyvan.stucoursebackend.repo.ICourseTypeRepo;
import com.eulbyvan.stucoursebackend.service.ICourseTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<CourseType> getAll() {
        return courseTypeRepo.findAll();
    }

    @Override
    public CourseType getById(Long id) {
        return courseTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("CourseType not found"));
    }

    @Override
    public CourseType add(CourseType newCourseType) {
        newCourseType.setName(newCourseType.getName().toUpperCase());
        return courseTypeRepo.save(newCourseType);
    }

    @Override
    public CourseType findByName(String name) {
        return courseTypeRepo.findByName(name).orElseThrow(() -> new NotFoundException("CourseType not found"));
    }

    @Override
    public CourseType updateById(Long id, CourseType courseType) {
        CourseType existingCourseType = courseTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("CourseType not found"));

        existingCourseType.setName(courseType.getName().toUpperCase());
        return courseTypeRepo.save(existingCourseType);
    }

    @Override
    public void deleteById(Long id) {
        courseTypeRepo.deleteById(id);
    }

    @Override
    public Long count() {
        return courseTypeRepo.count();
    }
}
