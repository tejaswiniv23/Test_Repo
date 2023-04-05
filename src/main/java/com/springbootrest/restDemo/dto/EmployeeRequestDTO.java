package com.springbootrest.restDemo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
	
	private Integer empId ;
	
	@NotEmpty
	private String empName;
	
	@NotEmpty
	
	private String empAdress;
	
	@NotNull(message="Mobile No sholud not be blank")
	private Integer empMobNo;
	
	@NotNull(message="Date of  birth should not be blank")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date empDOB;
	
	@NotNull(message="Employee joining date should not be blank")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date empJoiningDate;

}
