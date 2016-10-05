package com.cashier.reader;

import java.util.HashMap;
import java.util.Map;

class CatalogInMemory implements Catalog {
    private Map<String, Double> map = new HashMap<>();
    @Override
    public Double getPriceBy(String code) {
        return map.get(code);
    }

    public void add(String barcode, double price) {
        map.put(barcode, price);
    }
}
