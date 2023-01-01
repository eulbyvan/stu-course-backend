package com.eulbyvan.stucoursebackend.model.entity;

import com.eulbyvan.stucoursebackend.shared.annotation.UniqueCourseTitle;
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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "{stucourse.constraints.courseTitle.NotNull.message}")
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    @UniqueCourseTitle
    private String title;

    @ManyToOne
    private CourseType courseType;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String link;
}
