package com.projecthub.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String studentName;
    @Column(unique = true)
    private String rollNumber;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private int yearOfStudy;
    @Column(nullable = false)
    private String Phone;
}
