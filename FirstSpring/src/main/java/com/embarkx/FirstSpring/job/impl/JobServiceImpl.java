package com.embarkx.FirstSpring.job.impl;

import com.embarkx.FirstSpring.job.Job;
import com.embarkx.FirstSpring.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs){
            if(job.getId() == id){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
//        for(Job job : jobs){
//            if(job.getId() == id){
//                jobs.remove();
//            }
//        } This will not work
        Iterator<Job> itr = jobs.iterator();
        while(itr.hasNext()){
            Job job = itr.next();
            if(job.getId()==id){
                itr.remove();
                return true;
            }
        }
        return false;
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
        for(Job job : jobs){
            if(job.getId() == id){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
