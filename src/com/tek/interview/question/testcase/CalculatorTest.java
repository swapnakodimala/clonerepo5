package com.tek.interview.question.testcase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Calculator;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

/**
 * This is functionality of {@link Calculator}
 * 
 * @author SwapnaKodimala
 * 
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();

    }

    @Test
    public void testCalculatorForNullOrders() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Map<String, Order> ordersMap = new HashMap<>();
        ordersMap.put("Order 1", null);
        calculator.calculate(ordersMap);
        String str = "*******Order 1*******\r" + "\n" + "Sum of orders: 0.0\r" + "\n";
        Assert.assertEquals(outContent.toString(), str);
    }

    @Test
    public void testCalculatorForNegativePriceOrders() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Map<String, Order> ordersMap = new HashMap<>();
        Order order = new Order();
        order.add(new OrderLine(new Item("book", (float) -3.9), 1));
        ordersMap.put("Order 1", order);
        calculator.calculate(ordersMap);
        String str = "*******Order 1*******\r" + "\n" + "book: 0.0\r" + "\n" + "Sales Tax: 0.0\r" + "\n" + "Total: 0.0\r" + "\n" + "Sum of orders: 0.0\r" + "\n";
        Assert.assertEquals(outContent.toString(), str);
    }

    @Test
    public void testCalculatorForOrders() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Map<String, Order> ordersMap = new HashMap<>();
        Order order = new Order();
        order.add(new OrderLine(new Item("book", (float) 12.49), 1));
        order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
        order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
        ordersMap.put("Order 1", order);
        calculator.calculate(ordersMap);
        String str = "*******Order 1*******\r" + "\n" + "book: 13.74\r" + "\n" + "music CD: 16.49\r" + "\n" + "chocolate bar: 0.94\r" + "\n" + "Sales Tax: 2.84\r" + "\n"
                + "Total: 28.33\r" + "\n" + "Sum of orders: 28.33\r" + "\n";
        Assert.assertEquals(outContent.toString(), str);
    }
}
