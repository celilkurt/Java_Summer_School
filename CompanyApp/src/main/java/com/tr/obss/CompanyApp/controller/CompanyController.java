package com.tr.obss.CompanyApp.controller;


import com.tr.obss.CompanyApp.dao.CompanyRepository;
import com.tr.obss.CompanyApp.entity.Company;
import com.tr.obss.CompanyApp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {

        return companyService.getCompanyById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {

        return companyService.getCompanyByName(name);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Company> addCompanyWithEmployee(@Valid @RequestBody Company company) {

        return companyService.addCompany(company);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){

        return companyService.deleteUserById(id);
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){

        return companyService.updateCompany(company);
    }


}
