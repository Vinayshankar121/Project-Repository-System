package com.projecthub.auth.contoller;

import com.projecthub.auth.dto.StudentDto;
import com.projecthub.auth.entity.StudentEntity;
import com.projecthub.auth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }

    @GetMapping("/{id}")
    public Optional<StudentEntity> getUserById(@PathVariable Long id) {
        return studentService.getUserById(id);

    }

}
