package edu.ait.lawyer.dao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email")
    private String email;
    @NotNull(message = "Phone cannot be null")
    private String phone;
    @NotNull(message = "Location cannot be null")
    private String Location;
    private int experience;
}
