package com.eulbyvan.stucoursebackend.model;

import com.eulbyvan.stucoursebackend.shared.annotation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 8, max = 255)
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "{stucourse.constraints.password.Pattern.message}")
    private String password;
}

