package com.springbootrest.restDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.restDemo.Entity.Employee;
import com.springbootrest.restDemo.dao.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee createEmployee(Employee employeeRequest) {
		Employee  emp = new Employee();
		emp.setEmpName(employeeRequest.getEmpName());
		emp.setEmpAdress(employeeRequest.getEmpAdress());
		emp.setEmpMobNo(employeeRequest.getEmpMobNo());
		empRepo.save(emp);
		return emp;
	}
	
	@Override
	public Employee getASingleEmployee(Integer employeeId) {
		return empRepo.findById(employeeId).orElseThrow();
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
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
	public Long getEmpCount() {
		return empRepo.findAll().stream().count();
	}

	@Override
	public void deleteAllEmployee() {
		empRepo.deleteAllInBatch();
	}
}
