package com.reviewsMicroservice.reviewsMicroservice.reviews.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reviewsMicroservice.reviewsMicroservice.reviews.ReviewRepository;
import com.reviewsMicroservice.reviewsMicroservice.reviews.ReviewService;
import com.reviewsMicroservice.reviewsMicroservice.reviews.Reviews;

@Service
public class ReviewServicesImplemenation implements ReviewService{

    private ReviewRepository reviewRepository;
    public ReviewServicesImplemenation(ReviewRepository reviewRepo){
        this.reviewRepository = reviewRepo;
    }

    @Override
    public List<Reviews> getAllReviews(){
        return this.reviewRepository.findAll();
    }

    @Override
    public Reviews getReviewById(Long id, Long companyId) {
        List<Reviews> reviews = this.reviewRepository.findByCompanyId(companyId);
        if(reviews != null){
            for (Reviews review : reviews){
                if(review.getId().equals(id)){
                    return review;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addReviews(Reviews review) {
        try{
            this.reviewRepository.save(review);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteReviewById(Long id,Long companyId) {
        Reviews review = getReviewById(id, companyId);
        if(review != null) {
            this.reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Reviews updatedReview,Long id, Long companyId) {
        Optional<Reviews> review = this.reviewRepository.findById(id);
        if(review.isPresent()){
            Reviews newReview = review.get();
            this.reviewRepository.save(newReview);
            return true;
        }
        return false;
    }

    @Override
    public List<Reviews> getReviewByCompanyId(Long companyId) {
        return this.reviewRepository.findByCompanyId(companyId);
    }
    
}
