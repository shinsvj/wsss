package com.dbit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dbit.dao.SalesDisplayDAO;
import com.dbit.to.SalesDetailsTo;

public class SalesDetailsService {

	private SalesDisplayDAO dao;
	
	public SalesDetailsService() {
		dao=new SalesDisplayDAO();
	}
	
	public ArrayList<SalesDetailsTo>saleDisplayService() throws SQLException
	{
		return dao.saleDetails();
	}
}
