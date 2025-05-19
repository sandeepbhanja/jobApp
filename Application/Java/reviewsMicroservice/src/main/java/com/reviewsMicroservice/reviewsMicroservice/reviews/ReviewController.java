package com.reviewsMicroservice.reviewsMicroservice.reviews;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    ReviewService rs;

    public ReviewController(ReviewService revser){
        this.rs = revser;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getReviewsOfCompany(@PathVariable Long companyId) {
        return new ResponseEntity<>(this.rs.getReviewByCompanyId(companyId),HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> AddReviewsOfCompany(@PathVariable Long companyId , @RequestBody Reviews review) {
        boolean isSuccess = this.rs.addReviews(review);
        if(isSuccess){
            return new ResponseEntity<>("Review Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error while adding reviews",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReviewbyId(@PathVariable Long id, @RequestBody Reviews Review,@PathVariable Long companyId) {
        boolean isUpdated = this.rs.updateReview(Review, id, companyId);
        if(isUpdated){
            return new ResponseEntity<>("Review Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("No Review Id or Company Found",HttpStatus.NOT_FOUND); 
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long id,@PathVariable Long companyId) {
        Reviews review = this.rs.getReviewById(id, companyId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }
    

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id,@PathVariable Long companyId){
        boolean isDeleted = this.rs.deleteReviewById(id, companyId);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("No company or review ID found",HttpStatus.NOT_FOUND);
    }
}
