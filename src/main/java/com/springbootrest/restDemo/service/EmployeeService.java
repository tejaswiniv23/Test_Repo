package com.springbootrest.restDemo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootrest.restDemo.Entity.Employee;

@Component
public interface EmployeeService {
	 
	 	Employee createEmployee(Employee employeeRequest);
	    Employee updateEmployee(Integer employeeId, Employee employeeRequest);
	    void deleteEmployee(Integer employeeId);
	    Employee getASingleEmployee(Integer employeeId);
	    List<Employee> getAllEmployee();

}
