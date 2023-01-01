package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessResponse;
import com.eulbyvan.stucoursebackend.model.entity.CourseType;
import com.eulbyvan.stucoursebackend.service.ICourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@RestController
@RequestMapping("/api/1.0/course-types")
public class CourseTypeController {
    @Autowired
    ICourseTypeService courseTypeService;

    @PostMapping
    public ResponseEntity<GenericResponse> add(@Valid @RequestBody CourseType newCourseType) {
        // ignore the id field if it's provided in the request body
        newCourseType.setId(null);

        CourseType data = courseTypeService.add(newCourseType);

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.getReasonPhrase());
        res.setMessage("CourseType added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
