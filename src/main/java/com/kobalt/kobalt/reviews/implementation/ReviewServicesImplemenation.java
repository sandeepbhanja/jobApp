package com.kobalt.kobalt.reviews.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kobalt.kobalt.companies.Companies;
import com.kobalt.kobalt.companies.CompaniesService;
import com.kobalt.kobalt.reviews.ReviewRepository;
import com.kobalt.kobalt.reviews.ReviewService;
import com.kobalt.kobalt.reviews.Reviews;

@Service
public class ReviewServicesImplemenation implements ReviewService{

    private ReviewRepository reviewRepository;
    private CompaniesService companiesService;
    public ReviewServicesImplemenation(ReviewRepository reviewRepo,CompaniesService compService){
        this.reviewRepository = reviewRepo;
        this.companiesService = compService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId){
        return this.reviewRepository.findByCompanyId(companyId);
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
    public boolean addReviews(Reviews review,Long companyId) {
        try{
            Companies company = this.companiesService.getCompanyById(companyId);
            review.setCompany(company);
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
        Companies company = this.companiesService.getCompanyById(companyId);
        Optional<Reviews> review = this.reviewRepository.findById(id);
        if(review.isPresent()){
            Reviews newReview = review.get();
            newReview.setCompany(updatedReview.getCompany()!=null?updatedReview.getCompany():newReview.getCompany());
            newReview.setReview(updatedReview.getReview()!=null?updatedReview.getReview():newReview.getReview());
            newReview.setUserName(updatedReview.getUserName()!=null?updatedReview.getUserName():newReview.getUserName());
            newReview.setCompany(company);
            this.reviewRepository.save(newReview);
            return true;
        }
        return false;
    }
    
}
