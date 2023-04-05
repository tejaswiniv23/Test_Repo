package com.springbootrest.restDemo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootrest.restDemo.Entity.Employee;

public interface EmployeeService {
	 
	 	Employee createEmployee(Employee employeeRequest);
	    Employee updateEmployee(Integer employeeId, Employee employeeRequest);
	    void deleteEmployee(Integer employeeId);
	    Long getEmpCount();
	    Employee getASingleEmployee(Integer employeeId);
	    List<Employee> getAllEmployee();
	    void deleteAllEmployee();
	    Employee getEmployeeByIdAndName(Integer employeeId , String employeeName );
	    List<Employee> getAllEmployeesOrderByDOB();
	    List<Employee> getAllEmployeesOrderByJoiningDate();
}
