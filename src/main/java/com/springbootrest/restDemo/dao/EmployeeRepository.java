package com.springbootrest.restDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootrest.restDemo.Entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{
	


}
