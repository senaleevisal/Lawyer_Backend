package edu.ait.lawyer.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lawyer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String Location;
    private int experience;
}
