package com.eulbyvan.stucoursebackend.controller;

import com.eulbyvan.stucoursebackend.model.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.model.dto.response.SuccessResponse;
import com.eulbyvan.stucoursebackend.model.entity.sys.Role;
import com.eulbyvan.stucoursebackend.service.IRoleService;
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
@RequestMapping("/api/v1/roles")
public class RoleController {
    IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getById(@PathVariable Long id) {
        Role data = roleService.getById(id);

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Role retrieved by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping
    public ResponseEntity<GenericResponse> getAll() {
        List<Role> data = roleService.getAll();

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Roles retrieved");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> add(@Valid @RequestBody Role newRole) {
        // ignore the id field if it's provided in the request body
        newRole.setId(null);

        Role data = roleService.add(newRole);

        SuccessResponse res = new SuccessResponse();
        res.setCode("01");
        res.setStatus(HttpStatus.CREATED.toString());
        res.setMessage("Role added");
        res.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateById(@PathVariable Long id, @RequestBody Role role) {
        Role data = roleService.updateById(id, role);

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Role updated by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteById(@PathVariable Long id) {
        Role data = roleService.deleteById(id);

        SuccessResponse res = new SuccessResponse();
        res.setCode("00");
        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Role deleted by id: " + id);
        res.setData(data);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
