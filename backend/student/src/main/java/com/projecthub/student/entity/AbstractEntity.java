package com.projecthub.student.entity;

//

//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "abstracts")
//@Data                   // Generates getters, setters, toString, equals, and hashCode
//@NoArgsConstructor      // Generates no-args constructor
//@AllArgsConstructor     // Generates all-args constructor
//@Builder                // Enables builder pattern
//public class AbstractEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "abstract_id")
//    private Long abstractId;
//
//    @Column(name = "title", length = 200, nullable = false)
//    private String title;
//
//    @Column(name = "abstract", columnDefinition = "TEXT", nullable = false)
//    private String abstractText;
//
//    @Column(name = "technologies", length = 200)
//    private String technologies;
//
//    @Column(name = "department", length = 50)
//    private String department;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status", length = 20)
//    private Status status = Status.SUBMITTED;
//
//    @Column(name = "submitted_by", length = 50, nullable = false)
//    private String submittedBy;
//
//    @Column(name = "submitted_at")
//    private LocalDateTime submittedAt = LocalDateTime.now();
//
//    // Enum for status
//    public enum Status {
//        SUBMITTED,
//        APPROVED,
//        REJECTED
//    }
//}

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "abstracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "abstract_id")
    private Long abstractId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String abstractText;

    @Column(length = 200)
    private String technologies;

    @Column(length = 50)
    private String department;

    @Enumerated(EnumType.STRING)
    private Status status = Status.SUBMITTED;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "submitted_at", updatable = false)
    private LocalDateTime submittedAt=LocalDateTime.now();;

    public enum Status {
        SUBMITTED,
        UNDER_REVIEW,
        APPROVED,
        REJECTED
    }

}
