package com.tek.interview.question.testcase;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Foo;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class FooTest {
    @Before
    public void setUp() {
        Foo foo = new Foo();
    }

    @Test
    public void testFoo() throws Exception {
        Map<String, Order> expectedOrders = new HashMap<String, Order>();
        Order order = new Order();
        order.add(new OrderLine(new Item("book", (float) 12.49), 1));
        order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
        order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
        expectedOrders.put("Order 1", order);
        order = new Order();
        order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
        order.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));
        expectedOrders.put("Order 2", order);
        order = new Order();
        order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
        order.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
        order.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
        order.add(new OrderLine(new Item("box of importd chocolates", (float) 11.25), 1));
        expectedOrders.put("Order 3", order);
        Map<String, Order> ordersByOrderDescription = Foo.buildOrders();
        Assert.assertEquals(expectedOrders, ordersByOrderDescription);

    }
}
