package com.springbootrest.restDemo.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.restDemo.Entity.Employee;
import com.springbootrest.restDemo.dao.EmployeeRepository;
import com.springbootrest.restDemo.handler.CustomException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee createEmployee(Employee employeeRequest) {
		empRepo.save(employeeRequest);
		return employeeRequest;
	}

	@Override
	public Employee getASingleEmployee(Integer employeeId) {
		return empRepo.findById(employeeId).orElseThrow(() -> new CustomException("ERROR :","No Data Found for "+employeeId));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Integer employeeId, Employee employeeRequest) {
		Employee emp = new Employee();
		Employee employee = empRepo.findById(employeeId).orElseThrow(() ->new CustomException("ERROR :","No Data Found for "+employeeId));

		employee.setEmpName(employeeRequest.getEmpName());
		employee.setEmpMobNo(employeeRequest.getEmpMobNo());
		employee.setEmpAdress(employeeRequest.getEmpAdress());
		employee.setEmpDOB(employeeRequest.getEmpDOB());
		employee.setEmpJoiningDate(employeeRequest.getEmpJoiningDate());
		empRepo.save(employee);
		return employee;
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
		return empRepo.findByEmpIdAndEmpName(employeeId, employeeName).orElseThrow(() ->new CustomException("ERROR :","No Data Found for employee Id"+employeeId +"and employee name "+employeeName));
	}

	@Override
	public List<Employee> getAllEmployeesOrderByDOB() {
		return empRepo.getAllEmployeesOrderByDOB();
	}

	@Override
	public List<Employee> getAllEmployeesOrderByJoiningDate() {
		return empRepo.getAllEmployeesOrderByJoiningDate();
	}

}
