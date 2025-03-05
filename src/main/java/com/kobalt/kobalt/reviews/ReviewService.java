package com.kobalt.kobalt.reviews;

import java.util.List;


public interface ReviewService {
    List<Reviews> getAllReviews(Long companyId);
    Reviews getReviewById(Long id, Long companyId);
    boolean addReviews(Reviews review,Long companyId);
    boolean deleteReviewById(Long id,Long companyId);
    boolean updateReview(Reviews review,Long id, Long companyId);
}
