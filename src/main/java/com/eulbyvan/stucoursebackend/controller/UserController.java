package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.entity.User;
import com.eulbyvan.stucoursebackend.service.IUserService;
import com.eulbyvan.stucoursebackend.model.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessResponse;
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
@RequestMapping("/api/1.0/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<GenericResponse> add(@Valid @RequestBody User user) {
        // ignore the id field if it's provided in the request body
        user.setId(null);
        user.setRoles(null);
        user.setEnrollments(null);

        User data = userService.add(user);

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.getReasonPhrase());
        res.setMessage("User added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
