package com.deepaksingh.empmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepaksingh.empmanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
