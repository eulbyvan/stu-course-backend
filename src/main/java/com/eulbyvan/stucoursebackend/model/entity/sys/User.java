package com.eulbyvan.stucoursebackend.model.entity.sys;

import com.eulbyvan.stucoursebackend.model.entity.trx.Enrollment;
import com.eulbyvan.stucoursebackend.shared.annotation.UniqueUsername;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "display_name")
    private String displayName;
    @NotNull(message = "{stucourse.constraints.username.NotNull.message}")
    @Size(min = 3, max = 255)
    @Column(name = "username")
    @UniqueUsername
    private String username;
    @NotNull
    @Size(min = 8, max = 36)
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,36}$", message = "{stucourse.constraints.password.Pattern.message}")
    private String password;
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

    @ManyToMany
    @JsonIgnore
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Enrollment> enrollments;
}

