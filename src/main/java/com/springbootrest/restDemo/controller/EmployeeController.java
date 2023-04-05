package com.springbootrest.restDemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.springbootrest.restDemo.dto.EmployeeRequestDTO;
import com.springbootrest.restDemo.dto.EmployeeResponseDTO;
import com.springbootrest.restDemo.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/employee")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees () {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployee().stream().map(Employee -> modelMapper.map(Employee, EmployeeResponseDTO.class))
        		.collect(Collectors.toList());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		Employee employee = employeeService.getASingleEmployee(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}/{name}")
	public ResponseEntity<Employee> getEmployeeByIdAndName(@PathVariable("id") Integer id , @PathVariable("name") String name){
		Employee employee = employeeService.getEmployeeByIdAndName(id,name);
		return  new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/employee/getEmpCount")
	public ResponseEntity<Long> getEmpCount(){
	  long empCount = employeeService.getEmpCount();
		return new ResponseEntity<>(empCount,HttpStatus.OK);
	}
	
	@GetMapping("/employeeOrderByDOB")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployeesOrder () {
		
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployeesOrderByDOB().stream().map(Employee -> modelMapper.map(Employee, EmployeeResponseDTO.class))
        		.collect(Collectors.toList());
        logger.info("Request : "+employees);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@GetMapping("/employeeOrderByJoiningDate")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployeesOrderByJoiningDate () {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployeesOrderByJoiningDate().stream().map(Employee -> modelMapper.map(Employee, EmployeeResponseDTO.class))
        		.collect(Collectors.toList());
        logger.info("Request : "+employees);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@PostMapping(value="/addEmployee")
	public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody EmployeeRequestDTO emp)
	{ 
		logger.info("Request : "+emp);
		
		Employee employeeRequest = modelMapper.map(emp, Employee.class);
		employeeRequest = employeeService.createEmployee(employeeRequest);
		EmployeeResponseDTO empRes = modelMapper.map(employeeRequest, EmployeeResponseDTO.class);
		return new ResponseEntity<>(empRes,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeRequestDTO emp)
	{
		Employee employeeRequest = modelMapper.map(emp, Employee.class);
		employeeRequest = employeeService.updateEmployee(id, employeeRequest);
		EmployeeResponseDTO empRes = modelMapper.map(employeeRequest, EmployeeResponseDTO.class);
		return new ResponseEntity<>(empRes,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable("id") Integer id){
	  employeeService.deleteEmployee(id);
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteAllEmployee")
	public ResponseEntity<?> deleteEmployee(){
	  employeeService.deleteAllEmployee();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
