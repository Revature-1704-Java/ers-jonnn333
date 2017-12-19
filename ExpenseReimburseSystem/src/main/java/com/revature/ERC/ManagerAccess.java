package com.revature.ERC;

public class ManagerAccess {

	double reimbursementLimit = 0;
	String employeeID = "";
	String firstName = "";
	String lastName = "";
	int supApproval = 0;
	
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

	// constructors
	ManagerAccess() {
		
	}
	
	ManagerAccess(String id, double limit, int approve) {
		this.employeeID = id;
		this.reimbursementLimit = limit;
		this.supApproval = approve;
	}
	
	
}
