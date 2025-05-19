package com.jobsMicroservice.jobsMicroservice.job;

import java.util.List;

import com.jobsMicroservice.jobsMicroservice.job.DTO.JobDTO;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJobById(Job updatedJob,Long id);
}
