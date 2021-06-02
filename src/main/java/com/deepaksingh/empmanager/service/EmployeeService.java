package com.deepaksingh.empmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepaksingh.empmanager.model.Employee;
import com.deepaksingh.empmanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee emp){
		return employeeRepo.save(emp);
	}
	public void deleteEmployee(Long id){

		employeeRepo.deleteById(id);
	}
	
	public Employee findEmployeeByID(Long id) {
		return employeeRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by ID:" + id + " not found"));
		
	}
	
}
