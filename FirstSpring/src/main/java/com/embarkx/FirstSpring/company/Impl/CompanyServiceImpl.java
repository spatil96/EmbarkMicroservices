package com.embarkx.FirstSpring.company.Impl;

import com.embarkx.FirstSpring.company.Company;
import com.embarkx.FirstSpring.company.CompanyRepository;
import com.embarkx.FirstSpring.company.CompanyService;
import com.embarkx.FirstSpring.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate = companyOptional.get();
           companyToUpdate.setDescription(company.getDescription());
           companyToUpdate.setName(company.getName());
           companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createJob(Company company) {
        companyRepository.save(company);
    }
}
