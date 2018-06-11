package com.my.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.my.modle.customer;

public class fundTransferAccountSelectSevices {

	public  customer selectAccount(String accNo) throws ClassNotFoundException, SQLException {
		customer c=new customer();
		c.setAccountNo(accNo);
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select * from customer where AccountID='" + accNo + "'");
		rs.next();
		
		c.setFname(rs.getString("fname"));
		c.setLname(rs.getString("lname"));
		return c; 
		
	}
	
	
	public boolean checkAccountValid(String accNo) throws ClassNotFoundException, SQLException {
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select * from customer where AccountID='" + accNo + "'");
		if(rs.next()) {
			return false;
		}
		
		return true;
	}
}
