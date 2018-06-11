package com.my.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.my.modle.customerReg;

public class RegisterServices {

	public boolean CheckEmailAlreadyInUse(String email) throws SQLException, ClassNotFoundException {

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select email from customer where email='" + email + "'");

		if (rs.next() == true) {
			return true;
		}

		else {
			return false;
		}

	}

	public boolean CheckCustomerIsvalid(String accNo) throws SQLException, ClassNotFoundException {

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select AccountID from accounts where AccountID='" + accNo + "'");

		if (rs.next() == true) {
			return true;
		}

		else {
			return false;
		}

	}

	public boolean checkAccountNumberInUse(String AccNo) throws ClassNotFoundException, SQLException {
		// this function check that the bank account already has a online bank account

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select AccountID from customer where AccountID='" + AccNo + "'");

		if (rs.next() == true) {
			return true;
		}

		else {
			return false;
		}

	}

	public boolean checkSecurityKey(String AccNo) throws ClassNotFoundException, SQLException {
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select securityKey from accounts where AccountID='" + AccNo + "'");

		if (rs.next() == true) {
			return true;
		}

		else {
			return false;
		}
	}

	public String GenerateCustomerID() throws NumberFormatException, SQLException, ClassNotFoundException {
		System.out.println("loading generator");

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select max(customerid) from customer");

		int currentid;
		
		rs.next();
		
		currentid = rs.getInt(1);

		
		
		System.out.println("current id"+currentid);

		if (currentid >= 1000) {
			System.out.println("enterd");

			int newID = currentid + 1;

	

			String returnID = String.valueOf(newID);
			System.out.print("1 return id" + returnID);
			return returnID;
		}

	return"1000";

	}

	public void Registercustomer(customerReg n1) throws SQLException, ClassNotFoundException {

		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		String insert = "INSERT INTO customer" + "(CustomerID,AccountID,fname,lname,email,password)" + "VALUES ('"
				+ n1.getCustomerID() + "','" + n1.getAccountNo() + "','" + n1.getFname() + "','" + n1.getLname() + "','"
				+ n1.getEmail() + "','" + n1.getConfirmPassword() + "')";

		Statement stinsert = conn.createStatement();

		stinsert.executeUpdate(insert);

	}

}
