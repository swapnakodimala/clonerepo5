package com.tek.interview.question.testcase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;


public class OrderTest {
    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullOrderAdd() throws Exception {
        order.add(null);
    }

    @Test
    public void testAddOrder() throws Exception {
        Item item = new Item("imported", 20);
        OrderLine orderLine = new OrderLine(item, 2);
        order.add(orderLine);
        Assert.assertEquals(order.size(), 1);
        Assert.assertEquals(order.get(0), orderLine);
        order.clear();
        Assert.assertEquals(order.size(), 0);

    }

}
