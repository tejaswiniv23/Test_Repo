package com.springbootrest.restDemo.dto;

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

}
