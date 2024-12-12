package com.priyanshu.firstJobApp.repository;

import com.priyanshu.firstJobApp.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
//crudrepository can also be used
//jpa provides more funcitonality over the normal crud repo

//<Entity type ,Type of Primary Key>
public interface jobRepository extends JpaRepository<Job,Long> { //jparepository !!! module extended // spring data repo
} // done it will generate everything on it's own

