package com.eulbyvan.stucoursebackend.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -4410642648720018834L;

    public NotFoundException(String message) {
        super(message);
    }

}
