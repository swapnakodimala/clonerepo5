package com.tek.interview.question.testcase;

import org.junit.Assert;
import org.junit.Test;

import com.tek.interview.question.Item;


public class ItemTest {

    @Test
    public void testItemEmptyDescription() {
        float price = -2, defaultValue = 0;
        String testImported = "testImported";
        Item item = new Item(testImported, price);
        Assert.assertEquals(item.getDescription(), testImported);
        Assert.assertEquals(item.getPrice(), defaultValue, 0.0000f);
    }

}
