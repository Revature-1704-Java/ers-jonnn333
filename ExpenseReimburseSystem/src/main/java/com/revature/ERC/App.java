package com.revature.ERC;

import java.sql.SQLException;

/*
 Expense Reimbursement System (ERS)
 	[essentially a miniature project 1]
 	
 	Assigned: 12/18/17, morning of
 	Due		: 12/19/17, 6pm EST
 	
 	Requirements:
 		- Database with Employee, Reimbursements tables (generateData.com)
 		- Employee login (basic JSP)
 		- Reimbursement form submission (basic JSP)
 		- DAO (JDBC)
 		- Manager view 
 		- JUnit
 		
 	Unrelated todo: 1-on-1 (4) tomorrow morning, 12/19!
 		- will be asked about past SQL projects
 		- will be asked plan on this or project 1; looking for details when talking about it!
 
 */


public class App {
    public static void main( String[] args ) {
        
    	// test connection
    	ConnectionDAO db_connect = new ConnectionDAO();
    	
    	try {
			db_connect.getConnection();
		} catch (SQLException e) {
			System.out.println("Connection unsuccessful :( ");
			e.printStackTrace();
		}
    }
}
