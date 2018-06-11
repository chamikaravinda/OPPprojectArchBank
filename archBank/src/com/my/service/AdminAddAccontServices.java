package com.my.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.my.modle.TraditionalAccount;

public class AdminAddAccontServices {

	public String GenerateSecurityPin() {

		String uuid = UUID.randomUUID().toString();
		String pin = uuid.replace("-", "");
		return pin.substring(0,8);

	}
	
	
	public int AddToDB(TraditionalAccount t) throws ClassNotFoundException, SQLException{
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		String insert = "INSERT INTO accounts(AccountID,balance,securityKey) VALUES ('"
				+ t.getAccountNo() + "','" + t.getCurrentBalance() + "','" +t.getSecurityKey() + "')";

		Statement stinsert = conn.createStatement();

		int result=stinsert.executeUpdate(insert);
		return result;
	}
	
	
	public boolean checkAccountNotInDB(long AccNo) throws ClassNotFoundException, SQLException {
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select AccountID from accounts where AccountID='" + AccNo + "'");

		if (rs.next() == true) {
			return true;
		}

			return false;

	}

}
