package com.shopping.cart.model;

public class SpecialOffer {

	private double dicountRate;

	private int discountQuantity;

	public SpecialOffer(double discountRate, int discountQuantity) {
		this.dicountRate = discountRate;
		this.discountQuantity = discountQuantity;
	}
	
	public double getDicountRate() {
		return dicountRate;
	}

	public void setDicountRate(double dicountRate) {
		this.dicountRate = dicountRate;
	}

	public int getDiscountQuantity() {
		return discountQuantity;
	}

	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

}
