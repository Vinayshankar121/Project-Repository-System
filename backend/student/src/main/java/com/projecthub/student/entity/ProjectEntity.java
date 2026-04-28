package com.projecthub.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projects")
@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // Generates no-args constructor
@AllArgsConstructor     // Generates all-args constructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="project_title")
    private String projectTitle;

    @Column(length = 2000,name="abstract_text") // abstract might be long=
    private String abstractText;

    private String department;

    private int year;

    private String technologies;

    @Column(name = "github_link")
    private String githubLink;
    @Column(name = "user_id", nullable = false)
    private Long userId;
}
