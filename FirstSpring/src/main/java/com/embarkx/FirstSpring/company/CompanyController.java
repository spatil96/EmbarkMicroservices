package com.embarkx.FirstSpring.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Company> getAllCompanies(){
        return new ResponseEntity<Company>((Company) companyService.getAllCompanies(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Company company, Long id){
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added successfully", HttpStatus.CREATED);
    }
}
