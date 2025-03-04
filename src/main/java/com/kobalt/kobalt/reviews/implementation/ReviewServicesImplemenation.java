package com.kobalt.kobalt.reviews.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kobalt.kobalt.reviews.ReviewRepository;
import com.kobalt.kobalt.reviews.ReviewService;
import com.kobalt.kobalt.reviews.Reviews;

@Service
public class ReviewServicesImplemenation implements ReviewService{

    ReviewRepository reviewRepository;

    public ReviewServicesImplemenation(ReviewRepository reviewRepo){
        this.reviewRepository = reviewRepo;
    }

    @Override
    public List<Reviews> getAllReviews(String company){
        return this.reviewRepository.findAllByCompany(company);
    }

    @Override
    public Reviews getReviewById(Long id, String company) {
        return this.reviewRepository.findReviewIdByCompany(company, id);
    }

    @Override
    public boolean addReviews(Reviews review,String companyName) {
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
    public boolean deleteReviewById(Long id,String Company) {
        Optional<Reviews> review = this.reviewRepository.findReviewIdByCompanyOptional(Company, id);
        if(review.isPresent()){
            this.reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Reviews updatedReview,Long id,String company) {
        Optional<Reviews> review = this.reviewRepository.findReviewIdByCompanyOptional(company, id);
        if(review.isPresent()){
            Reviews newReview = review.get();
            newReview.setCompany(updatedReview.getCompany()!=null?updatedReview.getCompany():newReview.getCompany());
            newReview.setReview(updatedReview.getReview()!=null?updatedReview.getReview():newReview.getReview());
            newReview.setUserName(updatedReview.getUserName()!=null?updatedReview.getUserName():newReview.getUserName());
            this.reviewRepository.save(newReview);
            return true;
        }
        return false;
    }
    
}
