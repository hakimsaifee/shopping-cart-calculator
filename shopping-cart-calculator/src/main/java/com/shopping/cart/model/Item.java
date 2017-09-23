package com.shopping.cart.model;

public class Item {

	private String barCode;

	private String name;

	private double price;

	private String description;

	private int quantity;

	private SpecialOffer specialOffer;

	public String getBarCode() {
		return barCode;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addTotalPrice() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		return true;
	}

	private Item(ItemBuilder builder) {
		this.barCode = builder.barCode;
		this.name = builder.name;
		this.price = builder.price;
		this.description = builder.description;
		this.specialOffer = builder.specialOffer;
	}

	// Using builder pattern.
	public static class ItemBuilder {

		// mandatory fields.
		private String barCode;

		private String name;

		private double price;

		// optional fields.
		private String description;

		private SpecialOffer specialOffer;

		private int quantity;

		public ItemBuilder(String barCode, String name, double price) {
			this.barCode = barCode;
			this.name = name;
			this.price = price;
		}

		public ItemBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public ItemBuilder setSpecialOffer(SpecialOffer specialOffer) {
			this.specialOffer = specialOffer;
			return this;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Item build() {
			return new Item(this);
		}
	}
}
