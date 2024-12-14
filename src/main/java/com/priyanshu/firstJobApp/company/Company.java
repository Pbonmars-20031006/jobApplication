package com.priyanshu.firstJobApp.company;

import com.priyanshu.firstJobApp.job.Job;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String description;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;




    public Company(String name, Long id, String location, String description, List<Job> jobs) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.description = description;
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Company(){
    } // for jpa purposes or throws errors

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
