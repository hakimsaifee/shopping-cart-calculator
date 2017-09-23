package com.shopping.cart.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shopping.cart.constants.Currency;

/**
 * @author Hakim.s
 * 
 *         The Bill class is for printing the bill whatever format we want to.
 *
 */
public class Bill {

	/**
	 * capture total bill price.
	 */
	private double totalPrice;

	/**
	 * This map is having total price per item.
	 */
	private Map<Item, Double> calculatedPricePerItem = new ConcurrentHashMap<>();

	/**
	 * @return
	 */
	public Map<Item, Double> getCalculatedPricePerItem() {
		return calculatedPricePerItem;
	}

	/**
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setCalculatedPricePerItem(Map<Item, Double> calculatedPricePerItem) {
		this.calculatedPricePerItem = calculatedPricePerItem;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Prints the item , quantity , price and the total bill price.
	 */
	public void printBill() {
		StringBuilder sb = new StringBuilder("########################## Bill  #############################");
		sb.append("\n");
		sb.append("\n");
		sb.append("Item Code");
		sb.append("       ");
		sb.append("Item Name");
		sb.append("       ");
		sb.append("Quantity");
		sb.append("       ");
		sb.append("Price After Discount");
		sb.append("\n");

		calculatedPricePerItem.forEach((item, calculatedPrice) -> {
			sb.append(item.getBarCode());
			sb.append("       ");
			sb.append("       ");
			sb.append(item.getName());
			sb.append("       ");
			sb.append("       ");
			sb.append(item.getQuantity());
			sb.append("       ");
			sb.append("       ");
			sb.append(calculatedPrice);
			sb.append("\n");
		});

		sb.append("\n");
		sb.append("---------------------------");
		sb.append("-------------------");
		sb.append("Total : " + Currency.US_DOLAR + totalPrice);
		System.out.println(sb.toString());
	}
}
