package com.eulbyvan.stucoursebackend.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@NoArgsConstructor
public class ErrorResponse extends GenericResponse {
    public ErrorResponse(String code, String status, String message) {
        super.setCode("X00");
        super.setStatus("Error");
        super.setMessage("Something went wrong");
    }
}
