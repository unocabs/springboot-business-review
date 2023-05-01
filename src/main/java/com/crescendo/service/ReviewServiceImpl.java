package com.crescendo.service;

import com.crescendo.DTO.ReviewDTO;
import com.crescendo.entity.ReviewEntity;
import com.crescendo.model.Review;
import com.crescendo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    public List<ReviewDTO> getAllReviews() {

        return reviewRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewById(Integer businessId) {
        /*List<ReviewEntity> reviewEntities = reviewRepository.findAllByBusinessId(businessId);
        List<ReviewDTO> reviewDTOList = new ArrayList<>();

        reviewEntities.forEach(reviewEntity -> reviewDTOList.add(ReviewDTO.builder()
                        .id(reviewEntity.getId())
                        .businessId(reviewEntity.getBusinessId())
                        .text(reviewEntity.getText())
                        .rating(reviewEntity.getRating())
                        .createDateTime(reviewEntity.getCreatedDateTime())
                .build()));
        return reviewDTOList;*/
        List<ReviewDTO> reviewDTOList = reviewRepository.findAllByBusinessId(businessId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return reviewDTOList;
    }

    public List<ReviewDTO> addBusinessReview(Review review) {
        /*reviewRepository.save(ReviewEntity.builder()
                        .businessId(review.getBusinessId())
                        .text(review.getText())
                        .rating(review.getRating())
                        .createdDateTime(new Date())
                .build());*/
       reviewRepository.save(convertToEntity(review));

       return null;
    }

    private ReviewEntity convertToEntity(Review review) { return modelMapper.map(review, ReviewEntity.class);}
    private ReviewDTO convertToDTO(ReviewEntity reviewEntity) { return modelMapper.map(reviewEntity, ReviewDTO.class); }
}
