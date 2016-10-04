package com.cashier.reader;

import java.math.BigDecimal;

public class Product {
    private final String code;
    private final Price price;

    public Product(String code, Price price) {
        this.code = code;
        this.price = price;
    }

    public String getCurrency() {
        return price.getCurrency();
    }

    public BigDecimal getAmount() {
        return price.getAmount();
    }
}
