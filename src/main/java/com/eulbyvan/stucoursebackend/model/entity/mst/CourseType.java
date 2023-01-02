package com.eulbyvan.stucoursebackend.model.entity.mst;

import com.eulbyvan.stucoursebackend.shared.annotation.UniqueCourseTypeName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@Entity
@Table(name = "mst_course_types")
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
    @Column(name = "is_active")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int isActive = 1;
    @Column(name = "is_deleted")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int isDeleted = 0;
    @Column(name = "created_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "deleted_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime deletedDate = null;
    @Column(name = "updated_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedDate = null;
}
