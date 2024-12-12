package com.priyanshu.firstJobApp.service;

import com.priyanshu.firstJobApp.company.Company;
import com.priyanshu.firstJobApp.company.CompanyServiceInterface;
import com.priyanshu.firstJobApp.job.Job;
import com.priyanshu.firstJobApp.repository.companyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceInterface {


     companyRepository CompanyRepository;

    public CompanyService(companyRepository companyRepository) {
        CompanyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return CompanyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        CompanyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
       return CompanyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            CompanyRepository.deleteById(id);
            return true; // Return true on successful deletion
        } catch (Exception e) {
            return false; // Return false if there's an error
        }
    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {
        Optional<Company> companyOptional = CompanyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company existingJob = companyOptional.get();
            if (company.getName() != null) {
                existingJob.setName(company.getName());
            }
            if (company.getLocation() != null) {
                existingJob.setLocation(company.getLocation());
            }
            if (company.getDescription() != null) {
                existingJob.setDescription(company.getDescription());
            }
            if (company.getJobs() != null) {
                existingJob.setJobs(company.getJobs());
            }

            CompanyRepository.save(existingJob);
            return true;
        }
        return false;
    }
}
