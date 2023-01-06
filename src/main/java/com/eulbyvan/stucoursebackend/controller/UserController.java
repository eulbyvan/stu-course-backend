package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.dto.request.EditProfileReq;
import com.eulbyvan.stucoursebackend.model.dto.response.GenericRes;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessRes;
import com.eulbyvan.stucoursebackend.model.entity.sys.User;
import com.eulbyvan.stucoursebackend.service.IUserService;
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
@RequestMapping("/api/v1/users")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<GenericRes> add(@Valid @RequestBody User user) {
        // ignore the id field if it's provided in the request body
        user.setId(null);
        user.setRoles(null);
        user.setEnrollments(null);

        User data = userService.add(user);

        SuccessRes res = new SuccessRes();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.toString());
        res.setMessage("User added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericRes> getUser(@PathVariable Long id) {
        User data = userService.getById(id);

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("User retrieved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping
    public ResponseEntity<GenericRes> getAll() {
        List<User> data = userService.getAll();

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Users retrieved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenericRes> editProfile(@PathVariable Long id, @RequestBody EditProfileReq req) {
        EditProfileReq data = userService.editProfile(id, req);

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Profile saved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericRes> deleteById(@PathVariable Long id) {
        User data = userService.deleteById(id);

        SuccessRes res = new SuccessRes();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("User deleted by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
