package com.springbootrest.restDemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootrest.restDemo.Entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{

	Optional<Employee> findByEmpIdAndEmpName(Integer employeeId, String employeeName);

	@Query(nativeQuery = true , value = "select * from employee order by emp_dob desc")
	List<Employee> getAllEmployeesOrderByDOB();

	@Query(nativeQuery = true , value ="select * from employee order by emp_joining desc")
	List<Employee> getAllEmployeesOrderByJoiningDate();
	
}
