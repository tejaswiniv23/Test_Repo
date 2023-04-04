package com.springbootrest.restDemo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
	
	private Integer empId ;
	private String empName;
	private String empAdress;
	private int empMobNo;
	private Date empDOB;
	private Date empJoiningDate;

}
