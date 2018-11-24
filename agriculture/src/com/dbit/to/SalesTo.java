package com.dbit.to;

import javax.management.loading.PrivateClassLoader;

public class SalesTo {

	private String buyerName;
	private String mobileNumbe;
	private String saleComodity;
	private int saleQuantity;
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getMobileNumbe() {
		return mobileNumbe;
	}
	public void setMobileNumbe(String mobileNumbe) {
		this.mobileNumbe = mobileNumbe;
	}
	public String getSaleComodity() {
		return saleComodity;
	}
	public void setSaleComodity(String saleComodity) {
		this.saleComodity = saleComodity;
	}
	public int getSaleQuantity() {
		return saleQuantity;
	}
	public void setSaleQuantity(int saleQuantity) {
		this.saleQuantity = saleQuantity;
	}
	
}
