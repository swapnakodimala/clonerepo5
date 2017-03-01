package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderLine> orderLines = new ArrayList<>();

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
        return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
        this.orderLines.clear();
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderLines == null) ? 0 : orderLines.hashCode());
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
        Order other = (Order) obj;
        if (orderLines == null) {
            if (other.orderLines != null)
                return false;
        } else if (!orderLines.equals(other.orderLines))
            return false;
        return true;
    }

}