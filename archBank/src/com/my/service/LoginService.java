package com.my.service;

import java.sql.*;

public class LoginService {

	public boolean  Login(String UserName, String password) throws ClassNotFoundException, SQLException {

		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select email,password from customer ");
		
		while(rs.next()) {
			
			String UserNameDB = rs.getString("email"); //fetch the values present in database
			String passwordDB = rs.getString("password");
			 
			   if(UserName.equals(UserNameDB) && password.equals(passwordDB))
			   {
			      return true; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
			   }

		}
		
		return false;
	}

	// set first name

	public String setfname(String email) throws ClassNotFoundException, SQLException {

		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select fname from customer where email='" + email + "' LIMIT 1 ");

		String pt = null;

		while (rs.next()) {
			pt = rs.getString("fname");
		}

		return pt;

	}

	// get balance

	public String setBalance(String AccNO) throws ClassNotFoundException, SQLException {

		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select balance from accounts where AccountID='" + AccNO + "' LIMIT 1 ");

		String pt = null;

		while (rs.next()) {
			pt = rs.getString("balance");
		}

		return pt;

	}

	// get last name

	public String setLastname(String email) throws ClassNotFoundException, SQLException {

		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select lname from customer where email='" + email + "' LIMIT 1 ");

		String pt = null;

		while (rs.next()) {
			pt = rs.getString("lname");
		}

		return pt;

	}

	public String setAccNo(String email) throws ClassNotFoundException, SQLException {

		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select AccountID from customer where email='" + email + "'  ");

		String pt = null;

		while (rs.next()) {
			pt = rs.getString("AccountID");
		}

		return pt;

	}

}
