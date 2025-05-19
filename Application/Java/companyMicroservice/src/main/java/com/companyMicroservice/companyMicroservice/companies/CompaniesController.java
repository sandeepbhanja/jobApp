package com.companyMicroservice.companyMicroservice.companies;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private CompaniesService companiesService;

    public CompaniesController(CompaniesService companyService) {
        this.companiesService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Companies>> getCompanies() {
        return new ResponseEntity<>(this.companiesService.getCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> AddCompany(@RequestBody Companies company) {
        boolean isCompanyExist = this.companiesService.addCompany(company);
        if (isCompanyExist) {
            return new ResponseEntity<>("Company Added", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error while Adding Company", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyDetails(@PathVariable Long id,@RequestBody Companies company) {
        boolean isCompanyExist = this.companiesService.updateComapny(id, company);
        if(isCompanyExist){
            return new ResponseEntity<>("Company Details Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Company with such ID found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Companies> getCompanyById(@PathVariable Long id) {
        Companies isCompanyExist = this.companiesService.getCompanyById(id);
        if(isCompanyExist!=null){
            return new ResponseEntity<>(isCompanyExist, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean isCompanyExist = this.companiesService.deleteCompany(id);
        if(isCompanyExist){
            return new ResponseEntity<>("Company Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Company with such ID found", HttpStatus.NOT_FOUND);
    }    

}
