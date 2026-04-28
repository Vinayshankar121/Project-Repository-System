package com.projecthub.auth.service;

import com.projecthub.auth.dto.LoginDto;
import com.projecthub.auth.dto.LoginResponceDto;
import com.projecthub.auth.entity.StaffEntity;
import com.projecthub.auth.entity.StudentEntity;
import com.projecthub.auth.entity.UserEntity;
import com.projecthub.auth.enums.Role;
import com.projecthub.auth.repository.StaffRepository;
import com.projecthub.auth.repository.StudentRepository;
import com.projecthub.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private StudentEntity studentEntity;
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;
//    private final LoginResponceDto loginResponceDto;


    public LoginResponceDto login(LoginDto loginDto){



        UserEntity user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
    String name;
        String department;
        if(user.getRole() == Role.STUDENT){
            StudentEntity studentEntity=studentRepository.findByUser(user)
                    .orElseThrow(() -> new RuntimeException("Student profile not found"));

            name=studentEntity.getStudentName();
            department=studentEntity.getDepartment();

        }else{
            StaffEntity staffEntity=staffRepository.findByUser(user)
                    .orElseThrow(() -> new RuntimeException("Staff profile not found"));
            name=staffEntity.getStaff_name();
            department=staffEntity.getDepartment();
        }
    LoginResponceDto loginResponceDto=new LoginResponceDto();
         loginResponceDto.setUserId(user.getId());
         loginResponceDto.setRole(user.getRole());
         loginResponceDto.setName(name);
         loginResponceDto.setDepartment(department);
    return  loginResponceDto;

//        return new LoginResponceDto(
//                user.getId(),
//                user.getRole()
//        );

    }
}
