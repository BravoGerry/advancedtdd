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

	public void findPrice() {
	}

	public void sell() {
		double total = 0.0;
		for (Product p : cart) {
			total = total + p.price;
		}
		display.show(String.format("%.2f EUR", total));
	}

	public void acquire() {
		final String code = scanner.scan();
		final double price = catalog.getPriceBy(code);
		cart.add(new Product(code, price));

	}

	private class Product {
		final String code;
		final double price;

		public Product(String code, double price) {

			this.code = code;
			this.price = price;
		}
	}
}
