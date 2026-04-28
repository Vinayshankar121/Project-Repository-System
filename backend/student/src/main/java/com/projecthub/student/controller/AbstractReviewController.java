package com.projecthub.student.controller;

import com.projecthub.student.entity.AbstractReviewEntity;
import com.projecthub.student.service.AbstractReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class AbstractReviewController {
    private final AbstractReviewService abstractReviewService;
    @PostMapping("addReview")
    public void addReview(@RequestBody AbstractReviewEntity abstractReviewEntity){
        abstractReviewService.addReview(abstractReviewEntity);
    }

    @GetMapping("/previous/{staff_id}")
    public List<AbstractReviewEntity> showPreviousReviews(@PathVariable Long staff_id){
        return abstractReviewService.showPreviousReviews(staff_id);
    }
}
