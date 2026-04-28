package com.projecthub.student.repositary;

import com.projecthub.student.entity.AbstractReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbstractReviewRepositary extends JpaRepository<AbstractReviewEntity,Long> {

//    void findAllById(Long staffId);

    List<AbstractReviewEntity> findByStaffId(Long staffId);
}
