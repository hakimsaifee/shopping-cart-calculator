package com.shopping.cart.factory;

import com.shopping.cart.constants.BarCodeConstants;
import com.shopping.cart.model.Item;
import com.shopping.cart.model.SpecialOffer;

/**
 * @author Hakim.s
 *
 * A factory class which will take bar code and return the Item.
 * A temporary class which is not persisting items, later we can persist it to db.
 */
public class ItemFactory {

	public static Item resovleBarCode(String barCode) {

		switch (barCode) {
		case BarCodeConstants.APPLE_BAR_CODE:
			return new Item.ItemBuilder(barCode, "Apple", 5.00).setSpecialOffer(new SpecialOffer(12.00, 3)).build();

		case BarCodeConstants.BANANA_BAR_CODE:
			return new Item.ItemBuilder(barCode, "Banana", 4.00).setDescription("This is Banana")
					.setSpecialOffer(new SpecialOffer(10.00, 3)).build();

		case BarCodeConstants.PEAR_BAR_CODE:
			return new Item.ItemBuilder(barCode, "Pear", 3.00).build();

		default:
			return null;
		}
	}
}
