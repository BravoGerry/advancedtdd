package com.cashier.reader;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BarCodeReaderTest {

    @Test
    public void anyInputOutput8Eur() throws Exception {
        String result = new BarcodeReader().getPrice();
        assertEquals("8 Eur", result);
    }
}
