package com.kobalt.kobalt.reviews;

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
@RequestMapping("/companies")
public class ReviewController {

    ReviewService rs;

    public ReviewController(ReviewService revser){
        this.rs = revser;
    }

    @GetMapping("/{company}/reviews")
    public ResponseEntity<List<Reviews>> getReviewsOfCompany(@PathVariable String company) {
        return new ResponseEntity<>(this.rs.getAllReviews(company),HttpStatus.OK);
    }

    @PostMapping("/{company}/reviews")
    public ResponseEntity<String> AddReviewsOfCompany(@PathVariable String company , @RequestBody Reviews review) {
        boolean isSuccess = this.rs.addReviews(review,company);
        if(isSuccess){
            return new ResponseEntity<>("Review Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error while adding reviews",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping("/{company}/reviews/{id}")
    public ResponseEntity<String> updateReviewbyId(@PathVariable Long id, @RequestBody Reviews Review,@PathVariable String company) {
        boolean isUpdated = this.rs.updateReview(Review, id, company);
        if(isUpdated){
            return new ResponseEntity<>("Review Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("No Review Id or Company Found",HttpStatus.NOT_FOUND); 
    }

    @GetMapping("/{company}/reviews/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long id,@PathVariable String company) {
        Reviews review = this.rs.getReviewById(id, company);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @DeleteMapping("/{company}/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id,@PathVariable String company){
        boolean isDeleted = this.rs.deleteReviewById(id, company);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("No company or review ID found",HttpStatus.NOT_FOUND);
    }
    

}
