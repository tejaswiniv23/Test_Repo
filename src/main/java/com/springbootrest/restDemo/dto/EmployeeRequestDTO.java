package com.springbootrest.restDemo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
@Table(name = "employee")
public class EmployeeRequestDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_Id")
	private Integer empId ;
	
	@Column(name = "emp_Name")
	private String empName;
	
	@Column(name = "emp_Address")
	private String empAdress;
	
	@Column(name = "emp_Mobile")
	private Integer empMobNo;

}
