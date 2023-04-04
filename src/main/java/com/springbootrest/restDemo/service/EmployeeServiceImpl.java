package com.springbootrest.restDemo.service;

import java.text.SimpleDateFormat;
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

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Employee createEmployee(Employee employeeRequest) {
		empRepo.save(employeeRequest);
		return employeeRequest;
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
		Employee emp = new Employee();
		Optional<Employee> employee = empRepo.findById(employeeId);
		if (employee.isEmpty()) {
			return null;
		}
		else {
			emp = employee.get();
			emp.setEmpName(employeeRequest.getEmpName());
			emp.setEmpMobNo(employeeRequest.getEmpMobNo());
			emp.setEmpAdress(employeeRequest.getEmpAdress());
			emp.setEmpDOB(employeeRequest.getEmpDOB());
			emp.setEmpJoiningDate(employeeRequest.getEmpJoiningDate());
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

	@Override
	public Employee getEmployeeByIdAndName(Integer employeeId, String employeeName) {
		return empRepo.findByEmpIdAndEmpName(employeeId, employeeName).orElseThrow();
	}

	@Override
	public List<Employee> getAllEmployeesOrder() {
		return empRepo.getAllEmployeesOrder();
	}

	@Override
	public List<Employee> getAllEmployeesOrderByJoiningDate() {
		return empRepo.getAllEmployeesOrderByJoiningDate();
	}

}
