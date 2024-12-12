package com.priyanshu.firstJobApp.service;

import com.priyanshu.firstJobApp.job.Job;
import com.priyanshu.firstJobApp.job.JobServiceInterface;
import com.priyanshu.firstJobApp.repository.jobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements JobServiceInterface {

    jobRepository jobRepository;

    public JobService(com.priyanshu.firstJobApp.repository.jobRepository jobRepository) {
        this.jobRepository = jobRepository;
    } // it is a beann managed by spring , it will be autowired by spring during run time.
// All instantiations will be handled by spring

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createjob(Job job) {
        // Convert salary fields from String to Long before saving
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true; // Return true on successful deletion
        } catch (Exception e) {
            return false; // Return false if there's an error
        }
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job existingJob = jobOptional.get();

            // Update job fields, converting salary to proper type
            if (job.getTitle() != null) {
                existingJob.setTitle(job.getTitle());
            }
            if (job.getDescription() != null) {
                existingJob.setDescription(job.getDescription());
            }
            if (job.getMinSalary() != null) {
                existingJob.setMinSalary((job.getMinSalary()));  // Ensure this is Long
            }
            if (job.getMaxSalary() != null) {
                existingJob.setMaxSalary((job.getMaxSalary()));  // Ensure this is Long
            }
            if (job.getLocation() != null) {
                existingJob.setLocation(job.getLocation());
            }

            jobRepository.save(existingJob);
            return true;
        }
        return false;
    }
}