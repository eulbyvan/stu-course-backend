package com.eulbyvan.stucoursebackend.shared.dto.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
public class ErrorResponse extends GenericResponse {
    public ErrorResponse(String code, String message) {
        super(code, "Error", message);
    }
}
