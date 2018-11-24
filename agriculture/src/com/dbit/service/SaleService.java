package com.dbit.service;

import java.sql.SQLException;

import com.dbit.dao.SaleDao;
import com.dbit.to.SalesTo;

public class SaleService {
	
	SaleDao dao;

	public SaleService() {
		dao=new SaleDao();
	}
	
	public void insertSale(SalesTo salesTo) throws SQLException {
	
		dao.insertSale(salesTo);
		
	}	

}
