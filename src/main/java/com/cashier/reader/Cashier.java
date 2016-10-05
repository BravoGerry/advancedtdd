package com.cashier.reader;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
	private final Catalog catalog;
	private final Display display;
	private final Scanner scanner;

	private List<Product> cart = new ArrayList<>();


	public Cashier(Catalog catalog, Display display, Scanner scanner) {
		this.catalog = catalog;
		this.display = display;
		this.scanner = scanner;
	}


	public void sell() {
		double total = 0.0;
		for (Product p : cart) {
			total = total + p.price;
		}
		display.show(String.format("%.2f EUR", total));
	}

	public void acquire() {
		String code = scanner.scan();
		Product product = catalog.get(code);
		cart.add(product);
		display.show(String.format("%.2f G" + (product.regionalTax?"P":""), product.price));
	}

}
