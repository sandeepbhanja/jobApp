package com.companyMicroservice.companyMicroservice.companies;

import java.util.List;

public interface CompaniesService {
    List<Companies> getCompanies();
    Companies getCompanyById(Long id);
    boolean addCompany(Companies company);
    boolean updateComapny(Long id,Companies company);
    boolean deleteCompany(Long id);
}
