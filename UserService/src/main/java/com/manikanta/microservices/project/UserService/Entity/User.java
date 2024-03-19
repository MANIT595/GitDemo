package com.manikanta.microservices.project.UserService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty(message = "firstName should not be null or empty")
    private String firstName;

    @NotEmpty(message = "lastName should not be null or empty")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "password should not be null or empty")
    private String password;

}
