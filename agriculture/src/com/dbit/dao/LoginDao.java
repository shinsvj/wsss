package com.dbit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dbit.to.LoginTo;
import com.dbit.util.DBUtil;

public class LoginDao {
	Connection connection;

	public LoginDao() {
		connection = DBUtil.getConnection();
	}

	public boolean login(LoginTo loginTo) throws SQLException {

		String StrName = loginTo.getName();
		String StrPassword = loginTo.getPassword();
		String querry = "SELECT ADMIN_NAME,PASSWORD FROM ADMIN";
		boolean b = false;
		System.out.println("entering");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(querry);
		try {
			if (resultSet.next()) {
				if (StrName.equalsIgnoreCase(resultSet.getString("ADMIN_NAME"))
						&& StrPassword.equalsIgnoreCase(resultSet.getString("PASSWORD"))) {
					boolean b1 = true;
					return b1;
				} else {
					return b;
				}

			}
			return b;
		} finally {
			statement.close();
			resultSet.close();
		}
	}

	@Override
	public void finalize() throws Throwable {
		connection.close();
	}

}
