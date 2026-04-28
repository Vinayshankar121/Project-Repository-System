package com.projecthub.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDto {
    private String name;
    private String email;
    private String password;
    private String staffId;
    private String department;
    private String designation;
    private String phone;
}
