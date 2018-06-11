package com.my.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FundTransferServices {
	
	public double getCurrentBalance(String AccNo) throws SQLException, ClassNotFoundException {
		
			
			DBConnection db = new DBConnection();
			Connection conn = null;
			conn = db.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select balance from accounts where AccountID='" + AccNo + "'");
			
			rs.next();
			
			return rs.getDouble(1);
		
		
	}
	
	
	public double debitAccNewBalance(double transAmount,double balance) {
		
		return balance-transAmount;
		
	}
	
	public double creditAccNewBalance(double transAmount,double balance) {
		
		return balance+transAmount;
		
	}
	
	public boolean updateAccount(String accNo,double balance) throws ClassNotFoundException, SQLException {
		
		
		String update = "UPDATE accounts SET balance='"+balance+"' WHERE AccountID='"+accNo+"'";

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
	
	public String createTranIDcr() throws ClassNotFoundException, SQLException{
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select max(TransID) from transaction");

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
	
	public String createTranIDDr() throws ClassNotFoundException, SQLException{
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select max(TransID) from transaction");

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
	
	public boolean addTransaction(String accNo,String ID,Double amount,String type) throws SQLException, ClassNotFoundException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		String insert = "INSERT INTO transaction(AccountID,TransID,Amount,DRorCR) VALUES ('"
				+ accNo+"','" + ID + "','" +amount + "','"+type+"')";

		Statement stinsert = conn.createStatement();

		int result=stinsert.executeUpdate(insert);
		if(result>0) {
			return true;
		}
		return false;
		
	}
	
	


}
