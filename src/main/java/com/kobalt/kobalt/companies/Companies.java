package com.kobalt.kobalt.companies;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kobalt.kobalt.job.Job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="company_table")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private ArrayList<String> locations;
    private String description;
    
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Companies(){
    }
}
