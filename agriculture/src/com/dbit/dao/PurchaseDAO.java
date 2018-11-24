package com.dbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;

import com.dbit.to.PurchaseTO;
import com.dbit.util.DBUtil;

public class PurchaseDAO {

	private Connection connection;

	public PurchaseDAO() {
		connection = DBUtil.getConnection();
	}

	public void purchaseInsert(PurchaseTO purchaseTO) throws SQLException {
		String farName = purchaseTO.getFarmerName();
		String mobno = purchaseTO.getMobileNo();
		String comodity = purchaseTO.getComodity();
		int qty = purchaseTO.getQuantity();
		int invenQty;
		int updateQty;

		Date date = new Date();
		long time = date.getTime();
		java.sql.Date sqlDdate = new java.sql.Date(time);

		String insertQueryFarmer = "INSERT INTO FARMER(FARMER_ID,FARMER_NAME,MOB_NO) VALUES(FAR_SEQ.NEXTVAL,?,?)";
		String insertQueryPurchase = "INSERT INTO PURCHASE(PURCHASE_ID,FARMER_ID,BILL_NO,COMODITY,QTY,P_DATE) VALUES(PUR_SEQ.NEXTVAL,FAR_SEQ.CURRVAL,BILL_SEQ.NEXTVAL,?,?,?)";

		// selecting the comodity qty to update
		String inventorySelect = "SELECT QTY FROM INVENTORY WHERE COMODITY=?";
		PreparedStatement preparedStatementSelect = connection.prepareStatement(inventorySelect);

		String updateInventoryPurQuery = "UPDATE INVENTORY SET QTY=? WHERE COMODITY=?";

		PreparedStatement preparedStatementFarmer = connection.prepareStatement(insertQueryFarmer);
		PreparedStatement preparedStatementPurchase = connection.prepareStatement(insertQueryPurchase);
		PreparedStatement preparedStatementInventoryUpdate = connection.prepareStatement(updateInventoryPurQuery);
		ResultSet resultSet;

		try {
			connection.setAutoCommit(false);
			preparedStatementFarmer.setString(1, farName);
			preparedStatementFarmer.setString(2, mobno);

			preparedStatementPurchase.setString(1, comodity);
			preparedStatementPurchase.setInt(2, qty);
			preparedStatementPurchase.setDate(3, sqlDdate);

			int b1 = preparedStatementFarmer.executeUpdate();
			System.out.println("farmer table insert operation : " + b1);
			int b2 = preparedStatementPurchase.executeUpdate();
			System.out.println("purchase table insert operation : " + b2);

			// for doing update operation
			preparedStatementSelect.setString(1, comodity);
			resultSet = preparedStatementSelect.executeQuery();
			if (resultSet.next()) {
				invenQty = resultSet.getInt("QTY");
				updateQty = qty + invenQty;
				preparedStatementInventoryUpdate.setInt(1, updateQty);
				preparedStatementInventoryUpdate.setString(2, comodity);
				int up = preparedStatementInventoryUpdate.executeUpdate();
				System.out.println("inventory updated : " + up);
			}

			connection.commit();

			System.out.println("successfully inserted purchase data");
		} catch (Exception e) {
			connection.rollback();
		} finally {
			preparedStatementFarmer.close();
			preparedStatementPurchase.close();
			preparedStatementInventoryUpdate.close();
			preparedStatementSelect.close();
		}

	}

	@Override
	public void finalize() throws Throwable {
		connection.close();
	}

}
