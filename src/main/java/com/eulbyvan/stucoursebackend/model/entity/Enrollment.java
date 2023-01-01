package com.eulbyvan.stucoursebackend.model.entity;

import com.eulbyvan.stucoursebackend.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    private Course course;

    @Column(nullable = false)
    private String status;
}
