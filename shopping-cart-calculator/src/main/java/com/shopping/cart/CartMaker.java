package com.shopping.cart;

import com.shopping.cart.factory.ItemFactory;
import com.shopping.cart.model.Item;
import com.shopping.cart.model.ShoppingCart;

/**
 * @author Hakim.s
 *
 *This class will act as a Cart, which will have add or remove item api's.
 */
public class CartMaker implements Cart {

	public CartMaker() {

		initiazeCart();
	}

	private ShoppingCart shoppingCart;

	public void addItem(String barCode) {

		// get item using barCode;
		Item item = ItemFactory.resovleBarCode(barCode);
		this.shoppingCart.addOrUpdateItem(item);

	}

	public void removeItem(String barCode) {
		Item item = ItemFactory.resovleBarCode(barCode);
		this.shoppingCart.removeItem(item);
	}

	public void initiazeCart() {

		this.shoppingCart = new ShoppingCart();
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
}
