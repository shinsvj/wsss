package com.dbit.to;

import java.sql.Date;

public class PurchaseDetailsTo {

	private int farmerId;
	private String farName;
	private String mobNo;
	private int billNo;
	private String comodity;
	private int qty;
	private Date purDate;

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}

	public String getFarName() {
		return farName;
	}

	public void setFarName(String farName) {
		this.farName = farName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getComodity() {
		return comodity;
	}

	public void setComodity(String comodity) {
		this.comodity = comodity;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
