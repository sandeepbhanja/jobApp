package com.jobsMicroservice.jobsMicroservice.job.external;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private String userName;
    private String review;
    private Long companyId;
}
