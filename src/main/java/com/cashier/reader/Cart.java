package com.cashier.reader;

import java.util.List;

public interface Cart {
    void add(Product product);

    List<Product> getAll();
}
