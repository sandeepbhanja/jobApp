package com.kobalt.kobalt.reviews;

import java.util.List;


public interface ReviewService {
    List<Reviews> getAllReviews(String companyId);
    Reviews getReviewById(Long id, String company);
    boolean addReviews(Reviews review,String companyName);
    boolean deleteReviewById(Long id,String Company);
    boolean updateReview(Reviews review,Long id,String company);
}
