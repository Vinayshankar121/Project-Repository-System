package com.projecthub.auth.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(nullable = false)
    String staff_name;
    @Column(unique = true, nullable = false)
    String staff_id;
    @Column(nullable = false)
    String department;
    @Column(nullable = false)
    String designation;
    @Column(nullable = false)
    String phone;


}
