package com.cashier.reader;

import org.junit.Assert;
import org.junit.Test;


public class CatalogTest {
	@Test
	public void notFound() throws Exception {
		Assert.assertEquals(null, emptyCatalog().getPriceBy("::missing::"));
	}

	@Test
	public void found() throws Exception {
		Assert.assertEquals(new Double(100.0), catalogWith("::existing::", 100).getPriceBy("::existing::"));
	}

	private Catalog catalogWith(String barcode, double price) {
		CatalogInMemory catalogInMemory = new CatalogInMemory();
		catalogInMemory.add(barcode, price);
		return catalogInMemory;
	}

	private Catalog emptyCatalog() {
		return new CatalogInMemory();
	}

}