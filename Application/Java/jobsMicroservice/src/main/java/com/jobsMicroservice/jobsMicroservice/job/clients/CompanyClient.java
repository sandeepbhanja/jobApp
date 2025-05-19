package com.jobsMicroservice.jobsMicroservice.job.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jobsMicroservice.jobsMicroservice.job.external.Company;

@FeignClient(name="company-service",url="http://company-service.default:8082")
public interface CompanyClient {

    @GetMapping("/companies/{companyId}")
    Company getCompany(@PathVariable("companyId") Long companyId);
}
