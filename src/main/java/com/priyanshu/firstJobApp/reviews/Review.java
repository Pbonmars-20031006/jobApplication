package com.priyanshu.firstJobApp.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.priyanshu.firstJobApp.company.Company;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String title;
    private Double rating;  // for now just astring for testing purposes
    private String description;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Review(Long id, String title, Double rating,String description) {
        this.id = id;
        this.title = title;
        this.rating=rating;
        this.description = description;
    }

    public Review(){
        // this for the jpa repository to intiate a review table for us
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating= rating;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
