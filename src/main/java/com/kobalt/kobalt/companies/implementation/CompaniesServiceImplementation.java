package com.kobalt.kobalt.companies.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kobalt.kobalt.companies.Companies;
import com.kobalt.kobalt.companies.CompaniesRepository;
import com.kobalt.kobalt.companies.CompaniesService;

@Service
public class CompaniesServiceImplementation implements CompaniesService {

    CompaniesRepository companiesRepository;

    public CompaniesServiceImplementation(CompaniesRepository companyRepository) {
        this.companiesRepository = companyRepository;
    }

    @Override
    public List<Companies> getCompanies() {
        return companiesRepository.findAll();
    }

    @Override
    public boolean addCompany(Companies company) {
        try {
            this.companiesRepository.save(company);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateComapny(Long id, Companies company) {
        Optional<Companies> companyToUpdate = this.companiesRepository.findById(id);
        if (companyToUpdate.isPresent()) {
            Companies companyUpdated = companyToUpdate.get();
            companyUpdated.setTitle(company.getTitle() != null ? company.getTitle() : companyUpdated.getTitle());
            companyUpdated.setLocations(
                    company.getLocations() != null ? company.getLocations() : companyUpdated.getLocations());
            companyUpdated.setDescription(
                    company.getDescription() != null ? company.getDescription() : companyUpdated.getDescription());
            companyUpdated.setJobs(company.getJobs().size() != 0 ? company.getJobs() : companyUpdated.getJobs());
            this.companiesRepository.save(companyUpdated);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        Optional<Companies> comp = this.companiesRepository.findById(id);
        if (comp.isPresent()) {
            this.companiesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Companies getCompanyById(Long id) {
        return this.companiesRepository.findById(id).orElse(null);
    }

}
