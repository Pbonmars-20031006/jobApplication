package com.priyanshu.firstJobApp.job;

import jakarta.persistence.*;

@Entity // objects in database
//@Table(name="jobtable") // not necessary but can be used ot set a name, or else it sets the class name as table
public class Job {
    @Id // your primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;

//    @Version
//    private Integer version;

    public Job() { // YOU NEED A DEFAULT CONSTRUCTOR WHEN WE WORK WITH ENTIT'S USING JPA OR H2
    }// IT'S BEACUSE ENTITIES ARE OBJECTS WHIHC REPRESNT DATA. JPA POPULATES THE DATA WHEN INTANTIATED WITH RETRIVED DATA. so it needas this constructor without which it can retrieve the data


    public Job(Long id, String title, String description, Long maxSalary, Long  minSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
    }

    public Long  getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long  maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long  getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long  minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
