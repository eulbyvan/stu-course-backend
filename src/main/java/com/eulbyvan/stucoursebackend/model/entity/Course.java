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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false)
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
