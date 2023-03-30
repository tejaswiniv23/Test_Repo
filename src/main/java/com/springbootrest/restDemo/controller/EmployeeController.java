package com.springbootrest.restDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.restDemo.Entity.Employee;
import com.springbootrest.restDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		Employee employee = employeeService.getASingleEmployee(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee/{employee}")
	public ResponseEntity<Employee> addEmployee(@PathVariable("employee") Employee emp)
	{
		Employee employee = employeeService.createEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp)
	{
		Employee employee = employeeService.updateEmployee(id, emp);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id){
	  employeeService.deleteEmployee(id);
		return null;
	}

}
