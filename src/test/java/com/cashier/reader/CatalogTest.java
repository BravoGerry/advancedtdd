package com.cashier.reader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CatalogTest {
	@Test
	public void notFound() throws Exception {
		assertEquals(null, emptyCatalog().get("::missing::"));
	}

	@Test
	public void found() throws Exception {
		Catalog catalog = catalogWith("::existing::", new Product("::existing::", 100.0, false));
		Product product = catalog.get("::existing::");
		assertEquals(100.0, product.price, 0.0);
		assertEquals("::existing::", product.code);
		assertEquals(false, product.regionalTax);
	}

	private Catalog catalogWith(String barcode, Product product) {
		CatalogInMemory catalogInMemory = new CatalogInMemory();
		catalogInMemory.put(barcode, product);
		return catalogInMemory;
	}

	private Catalog emptyCatalog() {
		return new CatalogInMemory();
	}

}