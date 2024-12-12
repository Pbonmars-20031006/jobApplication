package com.priyanshu.firstJobApp.job;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JobServiceInterface {
    List<Job> findAll();
    void createjob(Job job);

    Job getJobById(Long Id);
    boolean deleteJobById(Long Id);

    boolean updateJobById(Long id,Job job);
}
