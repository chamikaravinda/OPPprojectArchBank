package com.my.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.my.modle.customer;

public class updateServices {

	public boolean checkEmailAlreadyInUse(String Email,String AccNo) throws ClassNotFoundException, SQLException {
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select email from customer where AccountID='" + AccNo + "'");

		String currentEmail = null;

		while (rs.next()) {
			currentEmail = rs.getString("email");
		}


		if (Email.equals(currentEmail)) {
			
			return false;
		}
		
		RegisterServices reg=new RegisterServices();
		
		return reg.CheckEmailAlreadyInUse(Email);
		
	}
	
	public boolean PasswordCorrect(String GivenPassword,String AccountNo) throws ClassNotFoundException, SQLException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select password from customer where AccountID='" + AccountNo + "'");
		
		String CurrentPassword = null;

		while (rs.next()) {
			CurrentPassword = rs.getString("password");
		}
		
		if(CurrentPassword.equals(GivenPassword)) {
			return true;
		}
		
		else {
			return true;
		}

	}
	
	public boolean Update(customer n1) throws ClassNotFoundException, SQLException {
		String update = "UPDATE customer SET fname='"+n1.getFname()+"', lname='"+n1.getLname()+"', email='"+n1.getEmail()+"' WHERE AccountID='"+n1.getAccountNo()+"'";

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(update);

		int rowsUpdated = statement.executeUpdate();

		if (rowsUpdated > 0) {
			return true;
		}
		else {
			return false;
		}

	}

}
