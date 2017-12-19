package com.revature.ERC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeAccess {

	double reimbursementLimit = 0;
	String employeeID = "";
	String firstName = "";
	String lastName = "";
	
	// constructors
	EmployeeAccess() {
		
	}
	
	EmployeeAccess(String id, String first, String last) {
		this.employeeID = id;
		this.firstName = first;
		this.lastName = last;
	}
	
	
	public double getReimbursementLimit() {
		return reimbursementLimit;
	}
	
	public void setReimbursementLimit(double reimbursementLimit) {
		this.reimbursementLimit = reimbursementLimit;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
