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
public class FailedRes extends GenericRes {
    public FailedRes(String code, String status, String message) {
        super.setCode("X00");
        super.setStatus("Failed");
        super.setMessage("Something went wrong");
    }
}
