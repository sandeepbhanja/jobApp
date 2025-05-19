package com.companyMicroservice.companyMicroservice.companies.DTO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewsDTO {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    
    public ArrayList<String> getCompanyReviews(Long companyId){
        ArrayList<String> reviews = new ArrayList<>();
        try{
            // String url = "http://reviewsMicroservice:8082/companies/" + companyId;
            // ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return reviews;
    }
}
