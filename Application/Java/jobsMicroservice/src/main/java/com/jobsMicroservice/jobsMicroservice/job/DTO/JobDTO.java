package com.jobsMicroservice.jobsMicroservice.job.DTO;

import java.util.List;

import com.jobsMicroservice.jobsMicroservice.job.external.Company;
import com.jobsMicroservice.jobsMicroservice.job.external.Review;

import lombok.Data;

@Data
public class JobDTO{
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Long companyId;
    private Company company;
    private List<Review> reviews;
}