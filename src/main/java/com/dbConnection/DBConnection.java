package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn;

	public static Connection MakeCon() {

		conn = null;
		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/hospital_db";
				String username = "root";
				String password = "*******";
				conn = DriverManager.getConnection(url, username, password);
			} else {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("An error/exception has been found inside DBConnection.java at that time create connection "+e);

		}

		return conn;
	}

}
