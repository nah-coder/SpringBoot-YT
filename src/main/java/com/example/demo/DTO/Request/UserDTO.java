package com.example.demo.DTO.Request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    @Size(min = 8,message = "USERNAME_VALID")

    private String username;
    @Size(min = 8,message = "PASSWORD_VALID")
    private String password;
    private LocalDate dob;
}
