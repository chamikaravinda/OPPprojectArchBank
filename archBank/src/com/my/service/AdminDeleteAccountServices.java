package com.my.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDeleteAccountServices {
	
	public boolean Delete(long AccNo) throws ClassNotFoundException, SQLException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select AccountID from customer where AccountID='" + AccNo + "'");

		if (rs.next()) {
			
			String sql = "DELETE FROM customer WHERE AccountID ='"+AccNo+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			String sql3 = "DELETE FROM billpay WHERE AccountID ='"+AccNo+"'";
			PreparedStatement pstmt3= conn.prepareStatement(sql3);
			pstmt3.executeUpdate();
			
			String sql4 = "DELETE FROM transaction WHERE AccountID ='"+AccNo+"'";
			PreparedStatement pstmt4= conn.prepareStatement(sql4);
			pstmt4.executeUpdate();
			
			String sql2 = "DELETE FROM accounts WHERE AccountID ='"+AccNo+"'";
			PreparedStatement pstmt2= conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			
			return true;
		}
		
		else if(rs.next()==false) {
			
			ResultSet rs2 = st.executeQuery("select AccountID from accounts where AccountID='" + AccNo + "'");
			if(rs2.next()==false) {
				return false;
			}
			
			String sql2 = "DELETE FROM accounts WHERE AccountID ='"+AccNo+"'";
			PreparedStatement pstmt2= conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			return true;
		}
		
		return false;

	}

}
