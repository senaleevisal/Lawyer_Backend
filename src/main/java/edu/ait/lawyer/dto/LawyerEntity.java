package edu.ait.lawyer.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class LawyerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Lob
    private Blob image;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String location;
    private String password;
    private String speciality;
    private int experience;
}