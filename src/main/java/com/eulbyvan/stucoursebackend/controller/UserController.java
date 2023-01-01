package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.User;
import com.eulbyvan.stucoursebackend.service.IUserService;
import com.eulbyvan.stucoursebackend.shared.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.shared.dto.response.SuccessResponse;
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

    @PostMapping()
    public ResponseEntity<GenericResponse> addUser(@Valid @RequestBody User req) {
        User user = userService.add(req);
        SuccessResponse res = new SuccessResponse("01", "Created", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
