package com.revature.ERC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
 Expense Reimbursement System (ERS)
 	[essentially a miniature project 1]
 	
 	Assigned: 12/18/17, morning of
 	Due		: 12/19/17, 6pm EST
 	
 	Requirements:
 		-[y] Database with Employee, Reimbursements tables (generateData.com)
 		-[y] Employee login
 		-[y] Reimbursement form submission 
 		-[y] DAO (JDBC)
 		-[y] Manager view 
 		-[y] JUnit
 		+[y] SQL script to create table(s)
 		*** don't yet have xp in display, so resorting to console print statements and scanner
 		
 	[y] Unrelated todo: 1-on-1 tomorrow morning, 12/19!
 		- will be asked about past SQL projects
 		- will be asked plan on this or project 1; looking for details when talking about it!
 		
 	+++ Project 1 
 		Can use bootstrap or your own custom css; call class and get whatever is contained in link that contains them
 
 */


public class App {
	
    public static void main( String[] args ) {
    	
    	int whileMarker = 1;
    	int subsequent_round = 0;
    	boolean ban = false;
    	int counter = 0;
    	int isEmployee = 0;
    	int isManager = 0;
    	
    	// Employee class
    	EmployeeAccessDAO employee = new EmployeeAccessDAO();
    	
    	// Manager class
    	ManagerAccessDAO manager = new ManagerAccessDAO();
    	
    	System.out.println("Welcome to the Employee Reimbursement System!");
    	System.out.println("Are you an Employee or Manager?");
    	
    	Scanner scan = null; 
    	String personType = "no";
    	
    	while (whileMarker == 1) {
    		
    		if (subsequent_round == 1) {
    			//System.out.println("Attempt #" + counter);
    			
    			if (counter == 3 && ban == false) {
    				System.out.println("YOU HAVE BEEN BANNED");
    				whileMarker = 0;
    				ban = true;
    			}
    			else {
    				System.out.println("Once again, are you an Employee or Manager?");
    			}
    		}
    		
    		try {
    			if (ban == false) {
    				scan = new Scanner(System.in);
    				personType = scan.nextLine();
    			}
        		
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}
    		
    		if (personType.equals("Employee") || personType.equals("employee")) {
    			
    			// do the Employee stuff
    			System.out.println("What is you EmployeeID?");
    			String eid = scan.nextLine();
    			
    			System.out.println("Attempting to log in as an Employee...");
    			
    			if (employee.isEmployee(eid) == true) {
    				 EmployeeAccess temp = employee.getEmployee(eid);
    				 System.out.println("Welcome, "+temp.getFirstName() + " " + temp.getLastName() + ".");
    				 whileMarker = 0;
    				 
    				 System.out.println("Enter your reimbursement amount: ");
    				 double amount = scan.nextDouble();
    				 manager.flagRequest(eid);
    				 
    			}
    			else {
    				break;
    			}
    			
    		}
    		else if (personType.equals("Manager") || personType.equals("manager")) {
    			
    			// do Manager stuff
    			System.out.println("Attempting to log in as a Manager...");
    			whileMarker = 0;
    			
    			System.out.println("You are currently in manager mode (currently all-access atm)");
    			System.out.println("What would you like to do next?	");
    			String managerAction = scan.nextLine();
    			
    			if (managerAction.equals("Reimbursements") || managerAction.equals("reimbursements")) {
    				System.out.println("Enter employeeID of persion you'd like to approve: ");
    				String enterID = scan.nextLine();
    				if (employee.isEmployee(enterID) == true) {
    					// do reimbursement
    					
    				}
    				else {
    					break;
    				}
    			}
    			else {
    				break;
    			}
    			
    		}
    		
    		else if (personType.equals("allManagers") || personType.equals("allmanagers")) {
    			List<ManagerAccess> ReimburseList = manager.getReimbursementTable();
    			for (ManagerAccess reimburse : ReimburseList) {
    				System.out.println("Employee with id = "+ reimburse.employeeID + " has limit of $" + reimburse.getReimbursementLimit());
    			}
    			whileMarker = 0;
    		}
    		
    		else if (personType.equals("allEmployees") || personType.equals("allemployees")) {
    			List<EmployeeAccess> employees = employee.getAllEmployees();
    			for (EmployeeAccess emp : employees) {
    				System.out.println("Employee with id: "+ emp.getEmployeeID() + ", whose name is: " + 
    						emp.getFirstName() + " " + emp.getLastName());
    			}
    			whileMarker = 0;
    		}
    		else {
    			if (ban == false) {
    				System.out.println("Not valid input.");
    			}
    			subsequent_round = 1;
    			counter++;
    		}
    		
    	}
    	scan.close();
    	System.out.println("Thank you for using the ERS. Have a nice day.");
    	
    }
}
