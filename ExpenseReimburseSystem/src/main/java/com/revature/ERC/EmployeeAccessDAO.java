package com.revature.ERC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.revature.beans.Bear;
//import com.revature.util.ConnectionUtil;

public class EmployeeAccessDAO {

	public List<EmployeeAccess> getAllEmployees() {
		PreparedStatement ps = null;
		EmployeeAccess EA = null;
		List<EmployeeAccess> Employees = new ArrayList<>();
		
		try(Connection conn = ConnectionDAO.getConnection()) {
			String sql = "SELECT * FROM Employee";
			ps = conn.prepareStatement(sql);
			//Add any variables to PS
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				//int id = rs.getInt("BEAR_ID");
				//String name = rs.getString("BEAR_NAME");
				//int age = rs.getInt("BEAR_AGE");
				//int weight = rs.getInt("BEAR_WEIGHT");
				
				//b = new Bear(id, name, age, weight);
				//bears.add(b);
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				
				EA = new EmployeeAccess(id, first, last);
				Employees.add(EA);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return Employees;
	}
	
	public EmployeeAccess getEmployee(String req_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeAccess EA = null;
		try(Connection conn = ConnectionDAO.getConnection()) {
			//String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, req_id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				//int bid = rs.getInt("BEAR_ID");
				//String name = rs.getString("BEAR_NAME");
				//int age = rs.getInt("BEAR_AGE");
				//int weight = rs.getInt("BEAR_WEIGHT");
				
				//b = new Bear(bid, name, age, weight);
				
				String id = rs.getString("EmployeeID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				
				EA = new EmployeeAccess(id, first, last);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return EA;
	}
	
	// ------ repurpose this function! :D -------
	public void feedBear(int bid, int bhid, int amt) {
		CallableStatement cs = null;
		try (Connection conn = ConnectionDAO.getConnection()) {
			String sql = "{CALL SP_FEED_BEAR(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, bid);
			cs.setInt(2, bhid);
			cs.setInt(3, amt);
			
			Boolean result = cs.execute();
			if (!result)
				System.out.println("Fed Bear");
			else
				System.out.println("Failed");
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
}
