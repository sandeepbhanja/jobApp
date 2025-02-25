package com.kobalt.kobalt.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kobalt.kobalt.job.Job;
import com.kobalt.kobalt.job.JobRepository;
import com.kobalt.kobalt.job.JobService;

@Service
public class JobServiceImplementation implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
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
