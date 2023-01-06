package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.shared.exception.NotFoundException;
import com.eulbyvan.stucoursebackend.model.entity.mst.CourseType;
import com.eulbyvan.stucoursebackend.repo.ICourseTypeRepo;
import com.eulbyvan.stucoursebackend.service.ICourseTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        return courseTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("Course type not found"));
    }

    @Override
    public CourseType add(CourseType newCourseType) {
        newCourseType.setName(newCourseType.getName().toUpperCase());
        return courseTypeRepo.save(newCourseType);
    }

    @Override
    public CourseType findByName(String name) {
        return courseTypeRepo.findByName(name).orElseThrow(() -> new NotFoundException("Course type not found"));
    }

    @Override
    public CourseType updateById(Long id, CourseType courseType) {
        CourseType existingCourseType = courseTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("Course type not found"));

        existingCourseType.setName(courseType.getName().toUpperCase());
        existingCourseType.setUpdatedDate(LocalDateTime.now());

        return courseTypeRepo.save(existingCourseType);
    }

    @Override
    public CourseType deleteById(Long id) {
        CourseType existingType = courseTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("Course type not found"));

        existingType.setIsActive(0);
        existingType.setIsDeleted(1);
        existingType.setDeletedDate(LocalDateTime.now());

        return courseTypeRepo.save(existingType);
    }

    @Override
    public Long count() {
        return courseTypeRepo.count();
    }
}
