package com.priyanshu.firstJobApp.reviews;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String date;  // for now just astring for testing purposes
    private Long jobId;
    private String description;

    public Review(Long id, String title, String date, Long jobId, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.jobId = jobId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
