package com.tr.obss.CompanyApp.dao;

import com.tr.obss.CompanyApp.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();

}
