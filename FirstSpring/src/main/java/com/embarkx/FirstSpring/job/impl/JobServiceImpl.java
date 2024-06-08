package com.embarkx.FirstSpring.job.impl;

import com.embarkx.FirstSpring.job.Job;
import com.embarkx.FirstSpring.job.JobRepository;
import com.embarkx.FirstSpring.job.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>(); //making it communicate with the DB
    JobRepository jobRepository;
//    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job : jobs){
//            if(job.getId() == id){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        for(Job job : jobs){
//            if(job.getId() == id){
//                jobs.remove();
//            }
//        } This will not work
//        Iterator<Job> itr = jobs.iterator();
//        while(itr.hasNext()){
//            Job job = itr.next();
//            if(job.getId()==id){
//                itr.remove();
//                return true;
//            }
//        }
//        return false; //This works
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
//        Iterator<Job> itr = jobs.iterator();
//        while(itr.hasNext()){
//            Job job = itr.next();
//            if(job.getId()==id){
//                job.setDescription("this is new description");
//                job.getMinSalary(updatedJob.getMaxSalary());
//                return true;
//            }
//        }
//        for(Job job : jobs){
//            if(job.getId() == id){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
