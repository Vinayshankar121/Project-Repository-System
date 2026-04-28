package com.projecthub.student.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "abstract_reviews")
@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // No-args constructor
 @AllArgsConstructor // All-args constructor @Builder
public class AbstractReviewEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long review_id;

    @Column(name = "abstract_id", nullable = false)
    private Long abstract_id;

    @Column(name = "staff_id", nullable = false)
    private Long staffId;

    @Enumerated(EnumType.STRING)
//    @Column(name = "action", nullable = false, length = 20)
    private Action action;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt = LocalDateTime.now();
    // Enum for decision
    public enum Action {
        APPROVED,
        REJECTED
    }
}
