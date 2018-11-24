package com.dbit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbit.to.PurchaseDetailsTo;
import com.dbit.util.DBUtil;

public class PurchaseDisplayDAO {
	private Connection connection;
	private ArrayList<PurchaseDetailsTo> arrayList = new ArrayList<>();

	public PurchaseDisplayDAO() {
		connection = DBUtil.getConnection();
	}

	public ArrayList<PurchaseDetailsTo> purchaseDetails() throws SQLException {
		String queryFarmerPurchase = "SELECT BILL_NO,F.FARMER_ID,FARMER_NAME,MOB_NO,COMODITY,QTY,P_DATE FROM FARMER F FULL OUTER JOIN PURCHASE P ON F.FARMER_ID=P.FARMER_ID";
		Statement statement = connection.createStatement();

		try {
			ResultSet resultSet = statement.executeQuery(queryFarmerPurchase);

			while (resultSet.next()) {

				int billno = resultSet.getInt("BILL_NO");
				int farmerId = resultSet.getInt("FARMER_ID");
				String farName = resultSet.getString("FARMER_NAME");
				String mobno = resultSet.getString("MOB_NO");
				String comodity = resultSet.getString("COMODITY");
				int qty = resultSet.getInt("QTY");

				Date date = resultSet.getDate("P_DATE");

				// System.out.println(purDate);

				// put all the values to TO
				PurchaseDetailsTo detailsTo = new PurchaseDetailsTo();

				detailsTo.setBillNo(billno);
				detailsTo.setFarmerId(farmerId);
				detailsTo.setFarName(farName);
				detailsTo.setMobNo(mobno);
				detailsTo.setComodity(comodity);
				detailsTo.setQty(qty);
				detailsTo.setPurDate(date);

				arrayList.add(detailsTo);
			}
		} finally {
			statement.close();
		}

		return arrayList;
	}

	@Override
	public void finalize() throws Throwable {
		connection.close();
	}
}
