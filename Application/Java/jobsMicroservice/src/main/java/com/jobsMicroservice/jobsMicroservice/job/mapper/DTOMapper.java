package com.jobsMicroservice.jobsMicroservice.job.mapper;

import org.springframework.stereotype.Component;

import com.jobsMicroservice.jobsMicroservice.job.Job;
import com.jobsMicroservice.jobsMicroservice.job.DTO.JobDTO;

@Component
public class DTOMapper {

    public JobDTO valueMapper(Job job , JobDTO jobWithDTO){
        jobWithDTO.setCompanyId(job.getCompanyId());
        jobWithDTO.setDescription(job.getDescription());
        jobWithDTO.setId(job.getId());
        jobWithDTO.setLocation(job.getLocation());
        jobWithDTO.setMaxSalary(job.getMaxSalary());
        jobWithDTO.setMinSalary(job.getMinSalary());
        jobWithDTO.setTitle(job.getTitle());
        return jobWithDTO;
    }
}
