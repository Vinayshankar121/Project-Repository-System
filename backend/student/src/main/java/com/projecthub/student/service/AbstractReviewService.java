package com.projecthub.student.service;

import com.projecthub.student.entity.AbstractReviewEntity;
import com.projecthub.student.repositary.AbstractReviewRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AbstractReviewService {
    private final AbstractReviewRepositary abstractReviewRepositary;

    public void addReview(AbstractReviewEntity abstractReviewEntity){

        abstractReviewRepositary.save(abstractReviewEntity);

    }

    public List<AbstractReviewEntity> showPreviousReviews(Long staff_id){
        return abstractReviewRepositary.findByStaffId(staff_id);
    }

}
