package com.eulbyvan.stucoursebackend.service.implementation;

import com.eulbyvan.stucoursebackend.model.dto.response.NotFoundException;
import com.eulbyvan.stucoursebackend.model.entity.mst.Course;
import com.eulbyvan.stucoursebackend.model.entity.mst.CourseType;
import com.eulbyvan.stucoursebackend.repo.ICourseRepo;
import com.eulbyvan.stucoursebackend.service.ICourseService;
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
public class CourseService implements ICourseService {
    private final ICourseRepo courseRepo;
    private final ICourseTypeService courseTypeService;

    public CourseService(ICourseRepo courseRepo, ICourseTypeService courseTypeService) {
        this.courseRepo = courseRepo;
        this.courseTypeService = courseTypeService;
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(Long id) {
        return courseRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Override
    public Course add(Course newCourse) {
        String courseTypeName = newCourse.getCourseType().getName().toUpperCase();
        CourseType existingCourseType = courseTypeService.findByName(courseTypeName);
        newCourse.setCourseType(existingCourseType);
        newCourse.setTitle(newCourse.getTitle().toUpperCase());
        return courseRepo.save(newCourse);
    }

    @Override
    public Course updateById(Long id, Course course) {
        Course existingCourse = courseRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));

        String courseTypeName = course.getCourseType().getName().toUpperCase();
        CourseType existingCourseType = courseTypeService.findByName(courseTypeName);

        existingCourse.setTitle(course.getTitle().toUpperCase());
        existingCourse.setCourseType(existingCourseType);
        existingCourse.setLink(course.getLink());
        existingCourse.setDuration(course.getDuration());
        existingCourse.setLevel(course.getLevel());
        existingCourse.setUpdatedDate(LocalDateTime.now());

        return courseRepo.save(existingCourse);
    }

    @Override
    public Course deleteById(Long id) {
        Course existingCourse = courseRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));

        existingCourse.setIsActive(0);
        existingCourse.setIsDeleted(1);
        existingCourse.setDeletedDate(LocalDateTime.now());

        return courseRepo.save(existingCourse);
    }

    @Override
    public Long count() {
        return null;
    }
}
