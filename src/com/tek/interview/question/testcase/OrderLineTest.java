package com.tek.interview.question.testcase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Item;
import com.tek.interview.question.OrderLine;


public class OrderLineTest {
    private OrderLine orderLine;

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = Exception.class)
    public void testOrderLineConstructor() throws Exception {
        orderLine = new OrderLine(null, 1);
    }

    @Test
    public void testOrderLine() throws Exception {
        Item item = new Item("Imported", 20);
        orderLine = new OrderLine(item, 2);
        Assert.assertEquals(orderLine.getItem(), item);
        Assert.assertEquals(orderLine.getQuantity(), 2);

    }

}
