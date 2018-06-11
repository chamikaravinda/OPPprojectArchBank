package com.my.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminLoginServices {

	public boolean Login(String username, String password) throws ClassNotFoundException, SQLException {
		DBConnection db = new DBConnection();
		Connection conn = null;

		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs;
		rs = st.executeQuery("select username,password from admin ");
		
		while(rs.next()) {
			
			String UserNameDB = rs.getString("username"); //fetch the values present in database
			String passwordDB = rs.getString("password");
			 
			   if(username.equals(UserNameDB) && password.equals(passwordDB))
			   {
			      return true; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
			   }

		}
		
		return false;
	}
	
	// set first name

		public String setfname(String username) throws ClassNotFoundException, SQLException {

			DBConnection db = new DBConnection();
			Connection conn = null;

			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs;
			rs = st.executeQuery("select fname from admin where username='" + username + "' LIMIT 1 ");

			String pt = null;

			while (rs.next()) {
				pt = rs.getString("fname");
			}

			return pt;

		}

		// get adminID

		public String adminID(String username) throws ClassNotFoundException, SQLException {

			DBConnection db = new DBConnection();
			Connection conn = null;

			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs;
			rs = st.executeQuery("select Admin_ID from admin where username='" + username + "' LIMIT 1 ");

			String pt = null;

			while (rs.next()) {
				pt = rs.getString("Admin_ID");
			}

			return pt;

		}

		// get last name

		public String setLastname(String username) throws ClassNotFoundException, SQLException {

			DBConnection db = new DBConnection();
			Connection conn = null;

			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs;
			rs = st.executeQuery("select lname from admin where username='" + username + "' LIMIT 1 ");

			String pt = null;

			while (rs.next()) {
				pt = rs.getString("lname");
			}

			return pt;

		}
		
		
		public String totalbankAccounts() throws ClassNotFoundException, SQLException {
			
			DBConnection db = new DBConnection();
			Connection conn = null;
			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select count(AccountID) from accounts");

			String count;
			
			rs.next();
			count = String.valueOf((rs.getInt(1)));
			
			return count;
			
			
		}
		
public String totalBankBalance() throws ClassNotFoundException, SQLException {
			
			DBConnection db = new DBConnection();
			Connection conn = null;
			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select sum(balance) from accounts");

			String count;
			
			rs.next();
			count = String.valueOf((rs.getInt(1)));
			
			return count;
			
			
		}

public String totalOnlinebankAccounts() throws ClassNotFoundException, SQLException {
	
	DBConnection db = new DBConnection();
	Connection conn = null;
	conn = db.getConnection();

	Statement st = conn.createStatement();

	ResultSet rs = st.executeQuery("select count(AccountID) from customer");

	String count;
	
	rs.next();
	count = String.valueOf((rs.getInt(1)));
	
	return count;
	
	
}

public String totalTransaction() throws ClassNotFoundException, SQLException {
	
	DBConnection db = new DBConnection();
	Connection conn = null;
	conn = db.getConnection();

	Statement st = conn.createStatement();

	ResultSet rs = st.executeQuery("select count(TransID) from transaction");

	String count;
	
	rs.next();
	count = String.valueOf((rs.getInt(1)));
	
	return count;
	
	
}

}
