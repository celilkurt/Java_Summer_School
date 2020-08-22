package com.tr.obss.CompanyApp.service;


import com.tr.obss.CompanyApp.dao.CompanyRepository;
import com.tr.obss.CompanyApp.entity.Company;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CompanyService {

    private static final Logger logger = Logger.getLogger(CompanyService.class);

    @Autowired
    CompanyRepository companyRepository;

    public ResponseEntity<Company> getCompanyById(long id){

        Optional<Company> user = companyRepository.findById(id);
        if(!user.isPresent()){
            logger.error("Company not found with id: " + id);
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<Company>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<Company> getCompanyByName(String name){

        Optional<Company> users = companyRepository.findByName(name);

        if(!users.isPresent()){
            logger.error("users or user not found with name: " + name);
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<Company>(users.get(), HttpStatus.OK);
    }

    public ResponseEntity<Company> addCompany(Company company){

        Company responseCompany = companyRepository.save(company);

        if(responseCompany != null){
            logger.info("Request to company user: " + company);
            return new ResponseEntity<Company>(responseCompany, HttpStatus.OK);
        }else{
            logger.error( "Company not saved: " + company);
            return new ResponseEntity<Company>(HttpStatus.NOT_ACCEPTABLE);
        }


    }

    public ResponseEntity<List<Company>> getAllCompanies() {

        List<Company> users = companyRepository.findAll();

        if(!users.isEmpty()){
            return new ResponseEntity<List<Company>>(users,HttpStatus.OK);
        }else{
            logger.error("Company or companies not found!");
            return new ResponseEntity<List<Company>>(HttpStatus.OK);
        }



    }



    public ResponseEntity<String> deleteUserById( Long id){

        logger.info("Request to delete company: " + id);
        companyRepository.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<Company> updateCompany( Company company){

        logger.info("Request to update company: " + company);

        Company newCompany = companyRepository.save(company);
        if(newCompany != null)
            return new ResponseEntity<Company>(newCompany,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


}
