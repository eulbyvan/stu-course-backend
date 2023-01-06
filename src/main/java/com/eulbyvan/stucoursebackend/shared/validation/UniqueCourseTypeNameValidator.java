package com.eulbyvan.stucoursebackend.shared.validation;

import com.eulbyvan.stucoursebackend.repo.ICourseTypeRepo;
import com.eulbyvan.stucoursebackend.shared.annotation.UniqueCourseTypeName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public class UniqueCourseTypeNameValidator implements ConstraintValidator<UniqueCourseTypeName, String> {
    @Autowired
    private ICourseTypeRepo courseTypeRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return courseTypeRepo.findByName(value.toLowerCase()).isEmpty();
    }
}
