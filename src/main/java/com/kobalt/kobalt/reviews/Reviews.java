package com.kobalt.kobalt.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kobalt.kobalt.companies.Companies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="reviews_table")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String review;

    @JsonIgnore
    @ManyToOne
    private Companies company;

    public Reviews(){}
}
