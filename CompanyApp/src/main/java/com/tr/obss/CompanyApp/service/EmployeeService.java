package com.tr.obss.CompanyApp.service;

import com.tr.obss.CompanyApp.dao.EmployeeRepository;
import com.tr.obss.CompanyApp.entity.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    private static final Logger logger = Logger.getLogger(CompanyService.class);


    public ResponseEntity<Employee> getUserById(long id){


        Optional<Employee> user = employeeRepository.findById(id);
        if(!user.isPresent()){
            logger.error("User not found with id: " + id);
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<Employee>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<Employee> getUserByName(String name){

        Optional<Employee> users = employeeRepository.findByName(name);

        if(!users.isPresent()){
            logger.error("User not found with name: " + name);
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<Employee>(users.get(), HttpStatus.OK);
    }

    public ResponseEntity<Employee> addEmployee(Employee employee){

        Employee responseEmployee = employeeRepository.save(employee);

        if(responseEmployee != null){
            logger.info("Request to create user: " + employee);
            return new ResponseEntity<Employee>(responseEmployee, HttpStatus.OK);
        }else{
            logger.error( "User not saved: " + employee);
            return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
        }


    }

    public ResponseEntity<Page<Employee>> getAllUsers(int pageNumber) {

        PageRequest pageable = PageRequest.of(pageNumber - 1, 2);
        Page<Employee> resultPage = employeeRepository.findAll(pageable);
        if (pageNumber > resultPage.getTotalPages()) {
            return new ResponseEntity<Page<Employee>>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Page<Employee>>(resultPage,HttpStatus.OK);

    }

    public ResponseEntity<List<Employee>> getAllUsers(){

        List<Employee> employees = employeeRepository.findAll();

        if(!employees.isEmpty()){
            return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
        }else{
            logger.error("Users not found!");
            return new ResponseEntity<List<Employee>>(HttpStatus.OK);
        }

    }





    public ResponseEntity<Employee> updateUser(Employee employee){

        logger.info("Request to update user: " + employee);

        Employee newEmployee = employeeRepository.save(employee);
        if(newEmployee != null)
            return new ResponseEntity<Employee>(newEmployee,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


}
