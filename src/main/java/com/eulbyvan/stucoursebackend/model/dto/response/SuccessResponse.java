package com.eulbyvan.stucoursebackend.model.dto.response;

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
public class SuccessResponse extends GenericResponse {
    private Object data;

    public SuccessResponse(String code, String status, String message) {
        super.setCode("00");
        super.setStatus("OK");
        super.setMessage("The process has been completed successfully");
    }
}
