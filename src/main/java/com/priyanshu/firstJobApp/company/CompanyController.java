package com.priyanshu.firstJobApp.company;

import com.priyanshu.firstJobApp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>>findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){

        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Succsfully", HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company foundCompany=companyService.getCompanyById(id);

        if(foundCompany!=null)
            return new ResponseEntity<>(foundCompany, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean foundCompany= companyService.deleteCompanyById(id);

        if(foundCompany)
            return new ResponseEntity<>("Company Deleted Succsfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody Company company){
        boolean  foundCompany= companyService.updateCompanyById(id,company);

        if(foundCompany)
            return new ResponseEntity<>("Company Updated Succsfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
