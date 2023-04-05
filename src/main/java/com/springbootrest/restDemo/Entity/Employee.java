package com.springbootrest.restDemo.Entity;

import java.util.Date;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE emp_Id=?")
public class Employee {
	
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
	
	@Column(name = "emp_DOB")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date empDOB;
	
	@Column(name = "emp_Joining")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date empJoiningDate;
	
	private boolean deleted = Boolean.FALSE;
}
