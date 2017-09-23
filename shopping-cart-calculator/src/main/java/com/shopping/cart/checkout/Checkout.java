package com.shopping.cart.checkout;

import com.shopping.cart.model.Bill;
import com.shopping.cart.model.ShoppingCart;

public interface Checkout {

	public Bill checkout(ShoppingCart shoppingCart);
}
