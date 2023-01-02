package com.eulbyvan.stucoursebackend.shared.validation;

import com.eulbyvan.stucoursebackend.repo.IUserRepo;
import com.eulbyvan.stucoursebackend.shared.annotation.UniqueUsername;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private IUserRepo userRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepo.findByUsername(value.toUpperCase()).isEmpty();
    }
}
