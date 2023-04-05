package com.springbootrest.restDemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootrest.restDemo.Entity.Employee;
import com.springbootrest.restDemo.dto.EmployeeRequestDTO;
import com.springbootrest.restDemo.service.EmployeeService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class RestDemoApplicationTests {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Test
	public void validateFields()
	{ 
		EmployeeRequestDTO empReqDTO = new EmployeeRequestDTO();
		empReqDTO.setEmpName("Test Rest Demo");
		empReqDTO.setEmpAdress("rtysfg");
		empReqDTO.setEmpMobNo(1234788765);
		empReqDTO.setEmpDOB(new Date());
		empReqDTO.setEmpJoiningDate(new Date());
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<EmployeeRequestDTO>> constraintViolations = validator.validate(empReqDTO);
	    assertThat(constraintViolations.size()).isZero();

	}
	
	@Test
	public void addEmployee()
	{ 
		Employee empReqDTO = new Employee();
		empReqDTO.setEmpName("TestAddEmployee");
		empReqDTO.setEmpAdress("rtysfg");
		empReqDTO.setEmpMobNo(1234788765);
		empReqDTO.setEmpDOB(new Date());
		empReqDTO.setEmpJoiningDate(new Date());
		
		Employee emp = empService.createEmployee(empReqDTO);
		assertThat(emp).isNotNull();

	}
	
	@Test
	public void  getAllEmployee()
	{
		List<Employee> emp = empService.getAllEmployee();
		assertThat(emp.size()).isGreaterThan(0);
	}
	
	@Test
	public void getEmployeeByIdAndName()
	{
		Integer id = 1;
		String empName = "test Put Code";
		Employee  emp = empService.getEmployeeByIdAndName(id,empName);
		assertThat(emp.getEmpId()).isNotNull();
	}
	
	@Test
	public void updateEmployee()
	{
		Integer empId = 1098;
		Employee emp2 = new Employee();
		emp2.setEmpName("XYZ");
		emp2.setEmpAdress("Mumbai");
		emp2.setEmpMobNo(456789098);
		emp2.setEmpDOB(new Date());
		emp2.setEmpJoiningDate(new Date());
		
		Employee emp = empService.updateEmployee(empId, emp2);
		assertThat(emp.getEmpName()).isEqualTo("XYZ");
	}
	
	@Test
	public void deleteEmployee()
	{
		Integer id = 26786;
		empService.deleteEmployee(id);
		Employee emp = empService.getASingleEmployee(id);
		assertThat(emp.getEmpId()).isNotNull();
	}
	
	@Test
	public void getEmpCount()
	{
		Employee empReqDTO = new Employee();
		empReqDTO.setEmpName("Test Count");
		empReqDTO.setEmpAdress("Mumbai");
		empReqDTO.setEmpMobNo(1278787834);
		empReqDTO.setEmpDOB(new Date());
		empReqDTO.setEmpJoiningDate(new Date());
		
		Employee emp = empService.createEmployee(empReqDTO);
	    Long empCount = empService.getEmpCount();
		assertThat(empCount).isGreaterThan(0);
	}
	
	@Test
	public void getEmployeeById()
	{
		Employee empReqDTO = new Employee();
		empReqDTO.setEmpName("Test getEmployeeById");
		empReqDTO.setEmpAdress("Mumbai");
		empReqDTO.setEmpMobNo(1278787834);
		empReqDTO.setEmpDOB(new Date());
		empReqDTO.setEmpJoiningDate(new Date());
		
		Employee emp = empService.createEmployee(empReqDTO);
		
		Employee empData = empService.getASingleEmployee(emp.getEmpId());
		assertThat(empData.getEmpId()).isNotNull();
		
	}
}
