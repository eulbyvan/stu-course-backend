package com.eulbyvan.stucoursebackend.model.entity;

import com.eulbyvan.stucoursebackend.shared.annotation.UniqueRoleName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@Entity
@Table(name = "sys_roles")
public class Role {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "{stucourse.constraints.roleName.NotNull.message}")
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    @UniqueRoleName
    private String name;
}
