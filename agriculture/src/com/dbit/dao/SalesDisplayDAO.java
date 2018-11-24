package com.dbit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbit.to.SalesDetailsTo;
import com.dbit.util.DBUtil;

public class SalesDisplayDAO {

	Connection connection;

	public SalesDisplayDAO() {
		connection = DBUtil.getConnection();
	}

	public ArrayList<SalesDetailsTo> saleDetails() throws SQLException {
		ArrayList<SalesDetailsTo> arrayList = new ArrayList<>();
		String strDispQuery = "SELECT BUYER_NAME,MOB_NO,B.BUYER_ID,BILL_NO,COMODITY,QTY,SDATE FROM BUYER B FULL OUTER JOIN SALE S ON B.BUYER_ID=S.BUYER_ID";

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(strDispQuery);
		try {
			while (resultSet.next()) {
				String buyerName = resultSet.getString("BUYER_NAME");
				String mobno = resultSet.getString("MOB_NO");
				int buyerId = resultSet.getInt("BUYER_ID");
				String billNo = resultSet.getString("BILL_NO");
				String comodity = resultSet.getString("COMODITY");
				int qty = resultSet.getInt("QTY");
				Date date = resultSet.getDate("SDATE");

				// putyin all the values to TO
				SalesDetailsTo detailsTo = new SalesDetailsTo();
				detailsTo.setBuyerName(buyerName);
				detailsTo.setMobno(mobno);
				detailsTo.setBuyid(buyerId);
				detailsTo.setBillno(billNo);
				detailsTo.setComodity(comodity);
				detailsTo.setQty(qty);

				// adding the TO to ArrayList
				arrayList.add(detailsTo);

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
