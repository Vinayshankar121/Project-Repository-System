package com.projecthub.auth.repository;

import com.projecthub.auth.entity.StudentEntity;
import com.projecthub.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Optional<StudentEntity> findByUser(UserEntity user);

}
