package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by charl on 5/29/2017.
 */
public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restockingWithDifferentItemsNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock Cheetos with Doritos");

        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    @Test
    public void overStockingNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");

        bin.restock("Lays", 100, 100, 50);
    }
}