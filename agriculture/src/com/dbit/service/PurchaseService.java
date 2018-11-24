package com.dbit.service;

import java.sql.SQLException;

import com.dbit.dao.PurchaseDAO;
import com.dbit.to.PurchaseTO;

public class PurchaseService {
	
	PurchaseDAO dao;
	public PurchaseService() {
		dao=new PurchaseDAO();
	}
	
	public void purchaseService(PurchaseTO purchaseTO) throws SQLException
	{
		dao.purchaseInsert(purchaseTO);
	}

}
