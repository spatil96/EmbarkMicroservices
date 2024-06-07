package com.embarkx.FirstSpring.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobController {
//    private List<Job> jobs = new ArrayList<>();
//    jobs.add("");
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
//    return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
//        jobs.add(job);
//        return "Job added Successfully";
        jobService.createJob(job);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
