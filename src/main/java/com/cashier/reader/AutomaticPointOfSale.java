package com.cashier.reader;

import java.math.BigDecimal;

public class AutomaticPointOfSale implements PointOfSale {

    private final BarCodeReader barCodeReader;
    private final Catalog catalog;
    private final Cart cart;
    private final Display display;

    public AutomaticPointOfSale(BarCodeReader barCodeReader, Catalog catalog, Cart cart, Display display) {
        this.barCodeReader = barCodeReader;
        this.catalog = catalog;
        this.cart = cart;
        this.display = display;
    }

    public void acquire() {
        String code = barCodeReader.shot();
        Product product = catalog.getProduct(code);
        cart.add(product);
    }

    @Override
    public void total() {
        Price result = new Price(BigDecimal.ZERO, "");
        for (Product product : cart.getAll()) {
            if (result.getCurrency().isEmpty()) {
                result.setCurrency(product.getCurrency());
            }
            result.setAmount(result.getAmount().add(product.getAmount()));
        }
        display.show(result);
    }
}
