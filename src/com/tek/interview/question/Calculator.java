package com.tek.interview.question;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * This class calculate the total price of the each orders.
 * 
 * @author SwapnaKodimala
 * 
 */
public class Calculator {

    public static double rounding(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }

    /**
     * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which is the item's price * quantity
     * * taxes.
     * 
     * For each order, print the total Sales Tax paid and Total price without taxes for this order
     */
    public void calculate(Map<String, Order> orders) {

        double grandtotal = 0;
        double totalAmountWithTaxes = 0;

        // Iterate through the orders
        for (Map.Entry<String, Order> entry : orders.entrySet()) {

            System.out.println("*******" + entry.getKey() + "*******");

            Order order = entry.getValue();
            double totalTax = 0.0;
            double total = 0.0;
            if (order == null) {
                continue;
            }

            // Iterate through the items in the order
            for (int i = 0; i < order.size(); i++) {
              
                // Calculate the taxes
                double tax = 0.0;
                Item item = order.get(i).getItem();
                
                if (item.getDescription().toUpperCase().contains("imported".toUpperCase())) {
                    // Extra 5% tax on imported items
                    tax = rounding(item.getPrice() * 0.15);
                } else {
                    tax = rounding(item.getPrice() * 0.10);
                }

                // Calculate the total price
                double totalprice = item.getPrice() + Math.abs(tax);

                // Print out the item's total price
                System.out.println(item.getDescription() + ": " + Math.abs(rounding(totalprice)));

                // Keep a running total
                totalTax += tax;
                total += order.get(i).getItem().getPrice();
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + Math.abs(rounding(totalTax)));
           
            // Print out the total amount
            System.out.println("Total: " + Math.abs(rounding(total)));
            grandtotal += total;
            totalAmountWithTaxes += total;
            
            totalAmountWithTaxes += totalTax;
        }

        System.out.println("Sum of orders: " + Math.abs(rounding(grandtotal)));
    }
}
