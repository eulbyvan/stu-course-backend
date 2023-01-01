package com.eulbyvan.stucoursebackend.model.dto.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
public class GenericResponse {
    private String code;
    private String status;
    private String message;
}
