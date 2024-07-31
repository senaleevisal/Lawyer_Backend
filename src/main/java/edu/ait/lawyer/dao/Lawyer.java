package edu.ait.lawyer.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lawyer {
    private int id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Phone cannot be null")
    private String phone;
    @NotNull(message = "Location cannot be null")
    private String location;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Speciality cannot be null")
    private String[] speciality;
    private int experience;
}