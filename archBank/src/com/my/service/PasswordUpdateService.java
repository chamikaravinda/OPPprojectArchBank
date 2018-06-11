package com.my.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.my.modle.CustomerPassword;

public class PasswordUpdateService {

	public String getCurrentPassword(String email) throws ClassNotFoundException, SQLException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		Statement st = conn.createStatement();

		// get current password
		ResultSet rs = st.executeQuery("select password from customer where email='" + email + "'");

		rs.next();
			String correctPass = rs.getString("password");
			
			return correctPass;
		}
		
	

	public int updatePassowrd(CustomerPassword c) throws SQLException, ClassNotFoundException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		
		
		String sql= "UPDATE customer SET password = '"+c.getNewPassword()+"'WHERE email ='"+c.getUser()+"' ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		int rowsUpdated=pstmt.executeUpdate();
		
		return rowsUpdated;
		
		
	}
	
}
