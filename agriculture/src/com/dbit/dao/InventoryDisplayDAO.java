package com.dbit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbit.to.InventoryTo;
import com.dbit.util.DBUtil;

public class InventoryDisplayDAO {

	private Connection connection;

	public InventoryDisplayDAO() {
		connection = DBUtil.getConnection();
	}

	public ArrayList<InventoryTo> inventoryDisplay() throws SQLException {
		// get values from inventory table from database
		String DispQuery = "SELECT COMODITY,QTY FROM INVENTORY";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(DispQuery);
		ArrayList<InventoryTo> arrayList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String strComodity = resultSet.getString("COMODITY");
				int qty = resultSet.getInt("QTY");
				InventoryTo inventoryTo = new InventoryTo();
				inventoryTo.setComodity(strComodity);
				inventoryTo.setQty(qty);

				arrayList.add(inventoryTo);
			}
		} finally {
			statement.close();
			resultSet.close();
		}

		return arrayList;
	}

	@Override
	public void finalize() throws Throwable {
		connection.close();
	}

}
