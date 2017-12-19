package com.revature.ERC;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerAccessDAO {

	public List<ManagerAccess> getReimbursementTable() {
		PreparedStatement ps = null;
		ManagerAccess MA = null;
		List<ManagerAccess> Managers = new ArrayList<>();
		
		try(Connection conn = ConnectionDAO.getConnection()) {
			String sql = "SELECT * FROM Reimbursements";
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
				double reimburseLimit = rs.getDouble("ReimburseLimit");
				int RequestApprove = rs.getInt("RequestApproval");
				//InputStream hold_blob = new InputStream();
				//hold_blob = rs.getBinaryStream("Attachments");
				int SupApprove = rs.getInt("SupervisorApproval");
				String SupReason = rs.getString("SupervisorReason");
				Date lastDate = rs.getDate("DateLastModified");
				
				MA = new ManagerAccess(id, reimburseLimit, SupApprove);
				Managers.add(MA);
				
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return Managers;
	}
	
	//////////////////////////////////////////////////////
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
	
}
