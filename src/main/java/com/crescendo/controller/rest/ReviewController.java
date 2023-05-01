package com.crescendo.controller.rest;

import com.crescendo.DTO.ReviewDTO;
import com.crescendo.model.Review;
import com.crescendo.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @GetMapping("/{businessId}")
    public List<ReviewDTO> getReviewById(@PathVariable Integer businessId) {
        return reviewService.getReviewById(businessId);
    }
    @PostMapping()
    public List<ReviewDTO> addBusinessReview(@RequestBody Review review) {
        return reviewService.addBusinessReview(review);
    }
}
