package edu.ait.lawyer.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lawyer {
    private int id;
    @NotEmpty(message = "Image cannot be null")
    private byte[] image;
    @NotBlank(message = "Name cannot be null")
    private String name;
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Phone cannot be null")
    private String phone;
    @NotEmpty(message = "Location cannot be null")
    private String[] location;
    @NotBlank(message = "Password cannot be null")
    private String password;
    @NotEmpty(message = "Speciality cannot be null")
    private String[] speciality;
    private int experience;
}