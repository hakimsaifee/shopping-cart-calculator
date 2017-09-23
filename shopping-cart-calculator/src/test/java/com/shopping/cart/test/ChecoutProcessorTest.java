package com.shopping.cart.test;

import org.junit.Test;

import com.shopping.cart.Cart;
import com.shopping.cart.CartMaker;
import com.shopping.cart.checkout.CheckoutProcessor;
import com.shopping.cart.constants.BarCodeConstants;
import com.shopping.cart.model.Bill;

public class ChecoutProcessorTest {

	/**
	 * Scenario 1:
	 * 
	 * This is the happy scenario. Apple and Banana are having special offers,
	 * but pear is having none. Apple : 5 price/unit ,special offer 12 for 3
	 * Banana : 4 price/unit , special offer 10 for 3 Pear : 3 price/unit , no
	 * offer;
	 */
	@Test
	public void testCheckoutProcess_Case_1() {

		System.out.println("Scenario 1 : ");
		// Create a cart and add items into it using bar code.
		Cart cart = new CartMaker();
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);

		cart.addItem(BarCodeConstants.BANANA_BAR_CODE);
		cart.addItem(BarCodeConstants.BANANA_BAR_CODE);
		cart.addItem(BarCodeConstants.BANANA_BAR_CODE);

		cart.addItem(BarCodeConstants.PEAR_BAR_CODE);
		cart.addItem(BarCodeConstants.PEAR_BAR_CODE);

		// Checkout the cart.
		CheckoutProcessor checkoutProcessor = new CheckoutProcessor();
		Bill bill = checkoutProcessor.checkout(cart.getShoppingCart());

		// Now print the bill.
		bill.printBill();
	}

	/**
	 * Scenario : 2 - Shop 4 Apples and 1 Banana.
	 * 
	 * Output for Apple should be : $12 for 3 apples and remaining 1 unit will be at $5. 
	 * Output for Banana should be : $4 for 1 unit.
	 */
	@Test
	public void testCheckoutProcess_Case_2() {

		System.out.println("Scenario 2 : ");

		// Create a cart and add items into it using bar code.
		Cart cart = new CartMaker();
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);

		cart.addItem(BarCodeConstants.BANANA_BAR_CODE);

		// Checkout the cart.
		CheckoutProcessor checkoutProcessor = new CheckoutProcessor();
		Bill bill = checkoutProcessor.checkout(cart.getShoppingCart());

		// Now print the bill.
		bill.printBill();
	}
	
	/**
	 * Scenario : 3 - Shop all items 1 unit only.
	 * 
	 * Output for Apple should be : $5 for 1 unit 
	 * Output for Banana should be : $4 for 1 unit.
	 * Output for Pear should be : $3 for 1 unit.
	 */
	@Test
	public void testCheckoutProcess_Case_3() {

		System.out.println("Scenario 3 : ");

		// Create a cart and add items into it using bar code.
		Cart cart = new CartMaker();
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);

		cart.addItem(BarCodeConstants.BANANA_BAR_CODE);

		cart.addItem(BarCodeConstants.PEAR_BAR_CODE);
		
		// Checkout the cart.
		CheckoutProcessor checkoutProcessor = new CheckoutProcessor();
		Bill bill = checkoutProcessor.checkout(cart.getShoppingCart());

		// Now print the bill.
		bill.printBill();
	}
	
	/**
	 * Scenario : 4 - Shop 6 Apples
	 * 
	 * Output for Apple should be : $12 for 3 unit so it will give price $24 by appliying offer on it.
	 */
	@Test
	public void testCheckoutProcess_Case_4() {
		
		System.out.println("Scenario 4 : ");
		
		// Create a cart and add items into it using bar code.
		Cart cart = new CartMaker();
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		cart.addItem(BarCodeConstants.APPLE_BAR_CODE);
		
		
		
		// Checkout the cart.
		CheckoutProcessor checkoutProcessor = new CheckoutProcessor();
		Bill bill = checkoutProcessor.checkout(cart.getShoppingCart());
		
		// Now print the bill.
		bill.printBill();
	}
}
