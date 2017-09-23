package com.shopping.cart;

import com.shopping.cart.model.ShoppingCart;

public interface Cart {

	void addItem(String barCode);
	
	void removeItem(String barCode);
	
	ShoppingCart getShoppingCart();
	
}
