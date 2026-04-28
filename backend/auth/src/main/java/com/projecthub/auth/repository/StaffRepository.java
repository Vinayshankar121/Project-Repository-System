package com.projecthub.auth.repository;

import com.projecthub.auth.entity.StaffEntity;
import com.projecthub.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
    Optional<StaffEntity> findByUser(UserEntity user);

}
