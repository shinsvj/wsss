package com.dbit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dbit.dao.InventoryDisplayDAO;
import com.dbit.to.InventoryTo;

public class InventoryDisplayService {
	
	private InventoryDisplayDAO displayDAO;
	
	public InventoryDisplayService() {
		displayDAO=new InventoryDisplayDAO();
	}
	
	public ArrayList<InventoryTo> inventoryDisplayService() throws SQLException
	{
		return displayDAO.inventoryDisplay();
	}
}
