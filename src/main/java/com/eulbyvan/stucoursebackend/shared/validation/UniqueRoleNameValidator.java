package com.eulbyvan.stucoursebackend.shared.validation;

import com.eulbyvan.stucoursebackend.repo.IRoleRepo;
import com.eulbyvan.stucoursebackend.shared.annotation.UniqueRoleName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return roleRepo.findByName(value.toLowerCase()).isEmpty();
    }
}
