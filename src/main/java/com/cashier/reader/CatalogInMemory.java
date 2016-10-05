package com.cashier.reader;

import java.util.HashMap;
import java.util.Map;

class CatalogInMemory implements Catalog {
    private Map<String, Product> map = new HashMap<>();
    @Override
    public Product get(String code) {
        return map.get(code);
    }

    public void put(String barcode, Product product) {
        map.put(barcode, product);
    }
}
