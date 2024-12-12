package com.priyanshu.firstJobApp.company;

import java.util.List;

public interface CompanyServiceInterface {

    List<Company> findAll();
    void createCompany(Company company);
    Company getCompanyById(Long id);
    boolean deleteCompanyById(Long Id);
    boolean updateCompanyById(Long Id, Company company);

}
