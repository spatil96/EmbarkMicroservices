package com.embarkx.FirstSpring.company.Impl;

import com.embarkx.FirstSpring.company.Company;
import com.embarkx.FirstSpring.company.CompanyRepository;
import com.embarkx.FirstSpring.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
private
    @Override
    public List<Company> getAllCompanies() {
        return List.of();
    }
}
