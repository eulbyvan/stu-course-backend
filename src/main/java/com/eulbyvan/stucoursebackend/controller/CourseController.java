package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessResponse;
import com.eulbyvan.stucoursebackend.model.entity.mst.Course;
import com.eulbyvan.stucoursebackend.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<GenericResponse> getAll() {
        List<Course> data = courseService.getAll();

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Courses retrieved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getById(@PathVariable Long id) {
        Course data = courseService.getById(id);

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course retrieved by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> add(@Valid @RequestBody Course newCourse) {
        // ignore the id field if it's provided in the request body
        newCourse.setId(null);

        Course data = courseService.add(newCourse);

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.toString());
        res.setMessage("Course added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateById(@PathVariable Long id, @RequestBody Course course) {
        Course data = courseService.updateById(id, course);

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course updated by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteById(@PathVariable Long id) {
        Course data = courseService.deleteById(id);

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course deleted by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
