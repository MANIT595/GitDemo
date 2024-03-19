package com.manikanta.microservices.project.UserService.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
    private Integer responseCode;
}
