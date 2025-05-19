package com.jobsMicroservice.jobsMicroservice.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jobsMicroservice.jobsMicroservice.job.DTO.JobDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    
    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAllJobs(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        System.out.println("Inside CreateJob");
        jobService.createJob(job);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobWithDTO = jobService.getJobById(id);
        if(jobWithDTO!=null){
            return new ResponseEntity<>(jobWithDTO,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJob(id);
        if(isDeleted){
            return ResponseEntity.ok("Job deleted successfully!");
        }
        else{
            return new ResponseEntity<>("No Job with such ID found",HttpStatus.NOT_FOUND); 
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job jobBody) {
        boolean isUpdated = jobService.updateJobById(jobBody,id);
        if(isUpdated){
            return ResponseEntity.ok("Job updated");
        }
        return new ResponseEntity<>("No Job with such ID found",HttpStatus.NOT_FOUND);
    }
    
}