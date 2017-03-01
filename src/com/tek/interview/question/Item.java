package com.tek.interview.question;
/*
 * represents an item, contains a price and a description.
 *
 */
public class Item {
	private String description;
    private float price, defaultprice = 0;

	public Item(String description, float price) {
        this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
        return price > defaultprice ? price : defaultprice;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(defaultprice);
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + Float.floatToIntBits(price);
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
        if (Float.floatToIntBits(defaultprice) != Float.floatToIntBits(other.defaultprice))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        return true;
    }
}