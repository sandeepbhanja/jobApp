package com.kobalt.kobalt.job;

import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kobalt.kobalt.companies.Companies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Table(name="job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @JsonIgnore
    @ManyToOne
    private Companies company;

    public Job(){
    }
}
