package com.eulbyvan.stucoursebackend.model.entity;

import com.eulbyvan.stucoursebackend.shared.annotation.UniqueCourseTypeName;
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
@Table(name = "course_types")
public class CourseType {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "{stucourse.constraints.courseTypeName.NotNull.message}")
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    @UniqueCourseTypeName
    private String name;
}
