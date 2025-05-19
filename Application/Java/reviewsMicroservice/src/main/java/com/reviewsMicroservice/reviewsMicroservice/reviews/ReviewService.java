package com.reviewsMicroservice.reviewsMicroservice.reviews;

import java.util.List;


public interface ReviewService {
    List<Reviews> getAllReviews();
    Reviews getReviewById(Long id, Long companyId);
    boolean addReviews(Reviews review);
    boolean deleteReviewById(Long id,Long companyId);
    boolean updateReview(Reviews review,Long id, Long companyId);
    List<Reviews> getReviewByCompanyId(Long companyId);
}
