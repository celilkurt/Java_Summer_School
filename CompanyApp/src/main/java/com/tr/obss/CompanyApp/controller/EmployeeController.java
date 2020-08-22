package com.tr.obss.CompanyApp.controller;

import com.tr.obss.CompanyApp.entity.Employee;
import com.tr.obss.CompanyApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getEmployeesByPageNumber(@RequestParam int pageNumber) {

        return employeeService.getAllUsers(pageNumber);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees() {

        return employeeService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        return employeeService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {

        return employeeService.getUserByName(name);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }


}
