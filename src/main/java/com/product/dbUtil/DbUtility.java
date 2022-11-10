package com.product.dbUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	public static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/db2";
	public static final String username="root";
	public static final String password="admin";
	public static Connection dBConn() throws SQLException, ClassNotFoundException
	{
		System.out.println("Inside utility: " +DRIVER_CLASS);
		Class.forName(DRIVER_CLASS);
		System.out.println("after Instantitation: " +DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
