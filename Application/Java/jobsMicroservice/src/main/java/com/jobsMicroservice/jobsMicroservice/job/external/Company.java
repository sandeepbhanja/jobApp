package com.jobsMicroservice.jobsMicroservice.job.external;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Company {
    private Long id;
    private String title;
    private ArrayList<String> locations;
    private String description;
}
