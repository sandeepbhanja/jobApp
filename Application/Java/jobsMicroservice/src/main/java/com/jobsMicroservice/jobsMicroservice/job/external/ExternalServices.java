package com.jobsMicroservice.jobsMicroservice.job.external;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jobsMicroservice.jobsMicroservice.job.clients.CompanyClient;
import com.jobsMicroservice.jobsMicroservice.job.clients.ReviewClient;

@Service
public class ExternalServices {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private ReviewClient reviewClient;

    public Company getCompany(Long companyId) {
        try {
            return companyClient.getCompany(companyId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Review> getReviews(Long companyId) {
        try {
            return reviewClient.getReviews(companyId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
