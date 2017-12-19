package com.revature.ERC;

import java.sql.SQLException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testApp()
    {
        assertTrue( true );
    }
    
    // actual tests here
    
    public void doesConnWork() {
    	// test connection
    	ConnectionDAO db_connect = new ConnectionDAO();
    	try {
			db_connect.getConnection();
			System.out.println("Okay, we're in.");
			assertTrue(true);
			
		} catch (SQLException e) {
			System.out.println("Connection unsuccessful :( ");
			e.printStackTrace();
		}
    	// end of code block for test connection
    }
    
    public void doesQueryWork () {
    	EmployeeAccessDAO employee = new EmployeeAccessDAO();
    	if (employee.isEmployee("EDF69ILV")) {
    		assertTrue(true);
    	}
    }
    
    
}
