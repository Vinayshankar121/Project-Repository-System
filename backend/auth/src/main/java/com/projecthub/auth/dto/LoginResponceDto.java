package com.projecthub.auth.dto;

import com.projecthub.auth.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponceDto {
    private Long userId;
    private Role role;
    private String name;
    private String department;
}
