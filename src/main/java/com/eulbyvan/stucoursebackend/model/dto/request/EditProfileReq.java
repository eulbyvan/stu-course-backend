package com.eulbyvan.stucoursebackend.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 02/01/2023
 */

@Data
public class EditProfileReq {
    @NotNull
    @Size(min=4, max=255)
    private String displayName;
}
