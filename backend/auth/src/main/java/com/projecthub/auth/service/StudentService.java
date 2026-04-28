package com.projecthub.auth.service;

import com.projecthub.auth.dto.StudentDto;
import com.projecthub.auth.entity.StudentEntity;
import com.projecthub.auth.entity.UserEntity;
import com.projecthub.auth.enums.Role;
import com.projecthub.auth.repository.StudentRepository;
import com.projecthub.auth.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addStudent(StudentDto studentDto) {

        if (userRepository.findByEmail(studentDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // 1. Save User (login info)
        UserEntity user = new UserEntity();
        user.setEmail(studentDto.getEmail());
        user.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        user.setRole(Role.STUDENT);

        UserEntity savedUser = userRepository.save(user);

        // 2. Save Student profile
        StudentEntity student = new StudentEntity();
        student.setUser(savedUser);
        student.setStudentName(studentDto.getName());
        student.setRollNumber(studentDto.getRollNumber());
        student.setDepartment(studentDto.getDepartment());
        student.setYearOfStudy(studentDto.getYear());
        student.setPhone(studentDto.getPhone());

        studentRepository.save(student);
    }

    public Optional<StudentEntity> getUserById(Long id) {
        return studentRepository.findById(id);
    }
}
