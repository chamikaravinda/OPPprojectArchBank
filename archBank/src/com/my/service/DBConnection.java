package com.my.service;

import java.sql.*;

public class DBConnection {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/archbank", "root", "root");
		return conn;
	}

}
