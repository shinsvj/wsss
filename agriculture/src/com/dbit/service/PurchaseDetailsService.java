package com.dbit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dbit.dao.PurchaseDisplayDAO;
import com.dbit.to.PurchaseDetailsTo;

public class PurchaseDetailsService {
	
	private PurchaseDisplayDAO displayDAO;
	
	public PurchaseDetailsService() {
		displayDAO=new PurchaseDisplayDAO();
	}
	
	public ArrayList<PurchaseDetailsTo> purchaseDetailsService() throws SQLException
	{
		return displayDAO.purchaseDetails();
	}
	

}
