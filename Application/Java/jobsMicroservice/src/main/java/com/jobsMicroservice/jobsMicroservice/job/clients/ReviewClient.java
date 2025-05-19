package com.jobsMicroservice.jobsMicroservice.job.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jobsMicroservice.jobsMicroservice.job.external.Review;

@FeignClient(name="review-service", url="http://review-service.default:8083")
public interface ReviewClient {
    @GetMapping("companies/{companyId}/reviews")
    List<Review> getReviews(@PathVariable("companyId") Long companyId);
}
