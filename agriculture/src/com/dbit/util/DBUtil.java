package com.dbit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection con;

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shinsoracle","shinsoracle");
			System.out.println("connected");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
