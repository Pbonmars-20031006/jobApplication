package com.priyanshu.firstJobApp.repository;

import com.priyanshu.firstJobApp.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface companyRepository extends JpaRepository<Company,Long> {
}
