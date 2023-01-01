package com.eulbyvan.stucoursebackend.shared.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
    private String code;
    private String status;
    private String message;
}
