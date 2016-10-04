package com.cashier.reader;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
	private final Catalog repository;
	private final Display display;
	private final Scanner scanner;

	private List<Product> cart = new ArrayList<>();


	public Cashier(Catalog catalog, Display display, Scanner scanner) {
		repository = catalog;
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

	public void next() {
		final String code = scanner.scan();
		final double price = repository.getPriceBy(code);
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
