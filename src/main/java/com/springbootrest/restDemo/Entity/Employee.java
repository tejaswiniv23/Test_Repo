package com.springbootrest.restDemo.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Employee {
	
	@Id
	private Integer empId ;
	private String empName;
	private String empAdress;
	private int empMobNo;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String empName, String empAdress, int empMobNo) {
		super();
		this.empId = empid;
		this.empName = empName;
		this.empAdress = empAdress;
		this.empMobNo = empMobNo;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empid) {
		this.empId = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAdress() {
		return empAdress;
	}
	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}
	public int getEmpMobNo() {
		return empMobNo;
	}
	public void setEmpMobNo(int empMobNo) {
		this.empMobNo = empMobNo;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empId + ", empName=" + empName + ", empAdress=" + empAdress + ", empMobNo="
				+ empMobNo + "]";
	}
	
	
	
	
	
	
	
	

}
