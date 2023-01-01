package com.eulbyvan.stucoursebackend.shared.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@NoArgsConstructor
public class ApiError {
    private long timestamp = new Date().getTime();
    private int status;
    private String message;
    private String url;
    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
