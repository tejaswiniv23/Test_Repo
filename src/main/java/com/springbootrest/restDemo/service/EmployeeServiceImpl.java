package com.springbootrest.restDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbootrest.restDemo.Entity.Employee;
import com.springbootrest.restDemo.dao.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee createEmployee(Employee employeeRequest) {
		Employee  emp = new Employee();
		emp.setEmpName("Test Code");
		emp.setEmpAdress("Mumbai");
		emp.setEmpMobNo(1234567890);
		empRepo.save(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Integer employeeId, Employee employeeRequest) {
		Employee  emp = new Employee();
		Optional<Employee> employee = empRepo.findById(employeeId);
		if(employee.isEmpty())
		{
			return null;
		}
		else
		{
			emp.setEmpName(employeeRequest.getEmpName());
			emp.setEmpMobNo(employeeRequest.getEmpMobNo());
			emp.setEmpAdress(employeeRequest.getEmpAdress());
			empRepo.save(emp);
			return emp;
			
		}
	}
	
	@Override
	public void deleteEmployee(Integer employeeId) {
		  empRepo.deleteById(employeeId);
	}

	@Override
	public Employee getASingleEmployee(Integer employeeId) {
		return empRepo.findById(employeeId).orElseThrow();
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

}
