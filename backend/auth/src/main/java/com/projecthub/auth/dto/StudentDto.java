package com.projecthub.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private String name;
    private String email;
    private String password;
    private String rollNumber;
    private String department;
    private int year;
    private String phone;
}
