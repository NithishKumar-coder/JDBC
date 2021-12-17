package com.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionCheck {

	public static Connection getConnection() {
		Connection connection = null;

		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3307/elh8"; 
			Class.forName(driverName); 
			connection = DriverManager.getConnection(url, "root", "root");
			System.out.println(connection != null ? "connection established" : "connection failed");

		} catch (ClassNotFoundException cnfe) {
			System.err.println("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			System.err.println("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			System.err.println(e);
		}
		return connection;
	}
}