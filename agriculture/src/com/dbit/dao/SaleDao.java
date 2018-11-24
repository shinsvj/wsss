package com.dbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

import com.dbit.to.SalesTo;
import com.dbit.util.DBUtil;

public class SaleDao {

	Connection connection;

	public SaleDao() {
		connection = DBUtil.getConnection();

	}

	public void insertSale(SalesTo salesTo) throws SQLException {

		int qty;
		int saleQuantity = salesTo.getSaleQuantity();

		String buyerName = salesTo.getBuyerName();
		String mobileno = salesTo.getMobileNumbe();
		String comodity = salesTo.getSaleComodity();
		int quantity = salesTo.getSaleQuantity();

		PreparedStatement preparedStatement;
		PreparedStatement preparedStatement2;
		PreparedStatement preparedStatement3;

		String inserQerrySale = "INSERT INTO SALE(SALE_ID,BUYER_ID,BILL_NO,COMODITY,QTY,SDATE) VALUES(SALE_SEQ.NEXTVAL,BUY_SEQ.CURRVAL,BUYBILL_SEQ.NEXTVAL,?,?,?)";
		preparedStatement = connection.prepareStatement(inserQerrySale);

		String insertQuerryBuyer = "INSERT INTO BUYER(BUYER_ID,BUYER_NAME,MOB_NO) VALUES(BUY_SEQ.NEXTVAL,?,?)";
		preparedStatement2 = connection.prepareStatement(insertQuerryBuyer);

		String selectInventory = "SELECT QTY FROM INVENTORY WHERE COMODITY=?";
		preparedStatement3 = connection.prepareStatement(selectInventory);

		String UpdateInventory = "UPDATE INVENTORY SET QTY=? WHERE COMODITY=?";
		PreparedStatement preparedStatement4 = connection.prepareStatement(UpdateInventory);

		try {
			connection.setAutoCommit(false);
			preparedStatement.setString(1, comodity);
			preparedStatement.setInt(2, quantity);
			Date date = new Date();
			long time = date.getTime();
			java.sql.Date sqlDate = new java.sql.Date(time);
			preparedStatement.setDate(3, sqlDate);

			preparedStatement2.setString(1, buyerName);
			preparedStatement2.setString(2, mobileno);

			// inserting user values to sale table
			int b1 = preparedStatement2.executeUpdate();
			System.out.println("Sale teble inserted =" + b1);

			// inserting user values to buyer table
			int b2 = preparedStatement.executeUpdate();
			System.out.println("buyer table inserted=" + b2);

			preparedStatement3.setString(1, comodity);
			// Selecting quantity using commodity
			ResultSet resultSet = preparedStatement3.executeQuery();

			if (resultSet.next()) {
				qty = resultSet.getInt("QTY");
				// deducting sold items from quantity
				saleQuantity = qty - quantity;
				preparedStatement4.setInt(1, saleQuantity);
				preparedStatement4.setString(2, comodity);

				// updating inventory table
				int b3 = preparedStatement4.executeUpdate();
				System.out.println("updated=" + b3);
			}

			connection.commit();

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void finalize() throws Throwable {
		connection.close();
	}

}
