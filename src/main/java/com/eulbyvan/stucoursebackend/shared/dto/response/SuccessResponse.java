package com.eulbyvan.stucoursebackend.shared.dto.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
public class SuccessResponse extends GenericResponse {
    private Object data;

    public SuccessResponse(String code, String message, Object data) {
        super(code, "success", message);
        this.data = data;
    }
}
