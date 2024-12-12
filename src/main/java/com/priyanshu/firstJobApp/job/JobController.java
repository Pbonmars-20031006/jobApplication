package com.priyanshu.firstJobApp.job;

import com.priyanshu.firstJobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jobs") // base url for all of them
public class JobController {

    private JobService JobService;

    public JobController(com.priyanshu.firstJobApp.service.JobService jobService) {
        JobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>>findAll(){
       return new ResponseEntity<>(JobService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job){
       JobService.createjob(job);
        return ResponseEntity.ok("Job Added Succesfully"); // another way of adding the response entity style
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job foundJob= JobService.getJobById(id);
        if(foundJob!=null)
                return new ResponseEntity<>(foundJob,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean f = JobService.deleteJobById(id);

        if (f)
            return ResponseEntity.ok("Job Succesfully deleted");
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> createJobs(@PathVariable Long id,@RequestBody Job job){
        boolean f=JobService.updateJobById(id,job);
        if(f)
            return ResponseEntity.ok("Job Upated Succesfully");
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
