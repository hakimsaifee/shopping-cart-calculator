package com.shopping.cart.checkout;

import com.shopping.cart.model.Bill;
import com.shopping.cart.model.Item;
import com.shopping.cart.model.ShoppingCart;

/**
 * @author Hakim.s
 *
 * A class is used to process the cart items and produce the final bill.
 */
public class CheckoutProcessor implements Checkout {

	private Bill bill;

	double totalPrice = 0.00;

	
	/* (non-Javadoc)
	 * @see com.shopping.cart.checkout.Checkout#checkout(com.shopping.cart.model.ShoppingCart)
	 * 
	 * The checkout method will take the cart and process on it.
	 * It will check for the special offer for the items and based on that it will resolve the final price.
	 */
	public Bill checkout(ShoppingCart shoppingCart) {

		bill = new Bill();

		shoppingCart.getItemWithQuantity().forEach((item, quantity) -> {

			double priceAfterDiscount = 0.00;

			if (isOfferApplicable(item, quantity)) {
				priceAfterDiscount = applyOffer(item, quantity);
			} else {
				priceAfterDiscount = item.getPrice() * quantity;
			}

			addItemsOnBill(item, priceAfterDiscount);

			totalPrice = totalPrice + priceAfterDiscount;

			item.addQuantity(quantity);
			
			addTotalPriceOnBill(totalPrice);
		});

		return bill;
	}


	/**
	 * @param item
	 * @param actualQuantity
	 * @return
	 * 
	 * It will take the item and quantity based on that it will evaluate the price,
	 *  considering special offer and give final price for the item. 
	 */
	private double applyOffer(Item item, Integer actualQuantity) {

		double finalPrice = 0.00;
		int specialQuantity = item.getSpecialOffer().getDiscountQuantity();
		if (actualQuantity % specialQuantity == 0) {
			finalPrice = (actualQuantity / specialQuantity) * item.getSpecialOffer().getDicountRate();
		} else {
			int noOfferOnQuantity = actualQuantity % specialQuantity;
			int offerOnQuantity = actualQuantity / specialQuantity;
			finalPrice = noOfferOnQuantity * item.getPrice();
			finalPrice = finalPrice + (offerOnQuantity * item.getSpecialOffer().getDicountRate());
		}

		return finalPrice;
	}

	/**
	 * @param item
	 * @param actualQuantity
	 * @return
	 * 
	 * Check whether item is eligible for offer or not.
	 */
	private boolean isOfferApplicable(Item item, int actualQuantity) {
		if (item.getSpecialOffer() == null || actualQuantity < item.getSpecialOffer().getDiscountQuantity()) {

			return false;
		}

		return true;

	}
	
	private void addTotalPriceOnBill(double totalPrice) {
		bill.setTotalPrice(totalPrice);

	}

	private void addItemsOnBill(Item item, double priceAfterDiscount) {
		bill.getCalculatedPricePerItem().put(item, priceAfterDiscount);
	}
	
}
