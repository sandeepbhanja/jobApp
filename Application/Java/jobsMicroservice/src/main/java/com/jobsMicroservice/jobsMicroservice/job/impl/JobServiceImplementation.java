package com.jobsMicroservice.jobsMicroservice.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobsMicroservice.jobsMicroservice.job.Job;
import com.jobsMicroservice.jobsMicroservice.job.JobRepository;
import com.jobsMicroservice.jobsMicroservice.job.JobService;
import com.jobsMicroservice.jobsMicroservice.job.DTO.JobDTO;
import com.jobsMicroservice.jobsMicroservice.job.external.Company;
import com.jobsMicroservice.jobsMicroservice.job.external.ExternalServices;
import com.jobsMicroservice.jobsMicroservice.job.external.Review;
import com.jobsMicroservice.jobsMicroservice.job.mapper.DTOMapper;


@Service
public class JobServiceImplementation implements JobService {
    JobRepository jobRepository;
    DTOMapper dtoMapper;
    ExternalServices extSer;
    public JobServiceImplementation(JobRepository jobRepository, DTOMapper dtoMapper, ExternalServices extSer) {
        this.jobRepository = jobRepository;
        this.dtoMapper = dtoMapper;
        this.extSer = extSer;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> allJobs = this.jobRepository.findAll();
        List<JobDTO> jobsWithDTO = new ArrayList<JobDTO>();
        for(Job job:allJobs){
            JobDTO jobWithDTO = new JobDTO();
            jobWithDTO = dtoMapper.valueMapper(job, jobWithDTO);
            
            Company jobCompany = this.extSer.getCompany(job.getCompanyId());
            List<Review> companyReviews = this.extSer.getReviews(job.getCompanyId());
            jobWithDTO.setCompany(jobCompany);
            jobWithDTO.setReviews(companyReviews);
            System.out.println("jobWithDRTO="+jobWithDTO.toString());
            jobsWithDTO.add(jobWithDTO);
        }
        return jobsWithDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        JobDTO jobWithDTO = new JobDTO();
        Optional<Job> job = this.jobRepository.findById(id);
        Job tempJob = job.orElse(null);
        if(tempJob == null){
            return null;
        }
        jobWithDTO = this.dtoMapper.valueMapper(tempJob, jobWithDTO);
        Company jobCompany = this.extSer.getCompany(tempJob.getCompanyId());
        List<Review> companyReviews = this.extSer.getReviews(tempJob.getCompanyId());
        jobWithDTO.setCompany(jobCompany);
        jobWithDTO.setReviews(companyReviews);
        System.out.println("jobWithDRTO="+jobWithDTO.toString());
        return jobWithDTO;
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Job updatedJob, Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setDescription(
                    updatedJob.getDescription() != null ? updatedJob.getDescription() : job.getDescription());
            job.setTitle(updatedJob.getTitle() != null ? updatedJob.getTitle() : job.getTitle());
            job.setLocation(updatedJob.getLocation() != null ? updatedJob.getLocation() : job.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary() != null ? updatedJob.getMaxSalary() : job.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary() != null ? updatedJob.getMinSalary() : job.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
