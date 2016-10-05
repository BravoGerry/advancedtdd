package com.cashier.reader;

public class Product {
    public String code;
    public double price;
    public boolean regionalTax;


    public Product(String code, double price, boolean regionalTax) {
        this.code = code;
        this.price = price;
        this.regionalTax = regionalTax;
    }
}
