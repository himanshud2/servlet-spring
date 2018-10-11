package com.infogain.beans;

import com.infogain.aspects.ProductStockInHand;

public class Product {
	private int pid;
	private String prodName;
	private int prodCost;
	private int quantityInHand;

	public Product()
	{}
	public Product(int pid, String prodName, int prodCost, int quantityInHand) {
		super();
		this.pid = pid;
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.quantityInHand = quantityInHand;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdCost() {
		return prodCost;
	}

	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}

	public int getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(int quantityInHand) {
		this.quantityInHand = quantityInHand;
	}
	public boolean validateQuantity() throws ProductStockInHand
	{
		if(quantityInHand<1)
			throw new ProductStockInHand();
		else return true;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", prodName=" + prodName + ", prodCost=" + prodCost + ", quantityInHand="
				+ quantityInHand + "]";
	}

}
