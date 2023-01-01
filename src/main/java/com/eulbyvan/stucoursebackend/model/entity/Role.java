package com.eulbyvan.stucoursebackend.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

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

    @Column(nullable = false)
    private String name;
}
