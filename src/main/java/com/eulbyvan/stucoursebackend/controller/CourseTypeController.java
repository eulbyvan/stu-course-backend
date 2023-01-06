package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.dto.response.GenericRes;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessRes;
import com.eulbyvan.stucoursebackend.model.entity.mst.CourseType;
import com.eulbyvan.stucoursebackend.service.ICourseTypeService;
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
@RequestMapping("/api/v1/course-types")
public class CourseTypeController {
    ICourseTypeService courseTypeService;

    public CourseTypeController(ICourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericRes> getById(@PathVariable Long id) {
        CourseType data = courseTypeService.getById(id);

        SuccessRes res = new SuccessRes();
        res.setCode("01");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course type retrieved by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping
    public ResponseEntity<GenericRes> getAll() {
        List<CourseType> data = courseTypeService.getAll();

        SuccessRes res = new SuccessRes();
        res.setCode("01");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course types retrieved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping
    public ResponseEntity<GenericRes> add(@Valid @RequestBody CourseType newCourseType) {
        // ignore the id field if it's provided in the request body
        newCourseType.setId(null);

        CourseType data = courseTypeService.add(newCourseType);

        SuccessRes res = new SuccessRes();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.toString());
        res.setMessage("CourseType added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericRes> updateById(@PathVariable Long id, @RequestBody CourseType courseType) {
        CourseType data = courseTypeService.updateById(id, courseType);

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course type updated by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericRes> deleteById(@PathVariable Long id) {
        CourseType data = courseTypeService.deleteById(id);

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Course type deleted by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
