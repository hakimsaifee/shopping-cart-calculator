package com.shopping.cart.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {

	Map<Item, Integer> itemWithQuantity = new ConcurrentHashMap<Item, Integer>();

	
	public void addOrUpdateItem(Item item) {
		if (!itemWithQuantity.containsKey(item)) {
			itemWithQuantity.put(item, 1);
		} else {
			itemWithQuantity.put(item, itemWithQuantity.get(item) + 1);
		}

	}

	public void removeItem(Item item) {
		if (!itemWithQuantity.containsKey(item)) {
			itemWithQuantity.remove(item);
		}

	}
	
	
	public Map<Item, Integer> getItemWithQuantity() {
		return itemWithQuantity;
	}
}
