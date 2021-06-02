package com.deepaksingh.empmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepaksingh.empmanager.model.Employee;
import com.deepaksingh.empmanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private final EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee emp = employeeService.findEmployeeByID(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp = employeeService.addEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	@DeleteMapping("/delete{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
