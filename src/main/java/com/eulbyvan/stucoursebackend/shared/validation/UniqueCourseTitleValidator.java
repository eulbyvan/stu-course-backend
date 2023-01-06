package com.eulbyvan.stucoursebackend.shared.validation;

import com.eulbyvan.stucoursebackend.repo.ICourseRepo;
import com.eulbyvan.stucoursebackend.shared.annotation.UniqueCourseTitle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

public class UniqueCourseTitleValidator implements ConstraintValidator<UniqueCourseTitle, String> {
    @Autowired
    private ICourseRepo courseRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return courseRepo.findByTitle(value.toLowerCase()).isEmpty();
    }
}
