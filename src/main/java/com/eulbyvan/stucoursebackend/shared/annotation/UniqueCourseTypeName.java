package com.eulbyvan.stucoursebackend.shared.annotation;

import com.eulbyvan.stucoursebackend.shared.validation.UniqueCourseTypeNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Constraint(validatedBy = UniqueCourseTypeNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCourseTypeName {
    String message() default "{stucourse.constraints.roleName.UniqueCourseTypeName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
