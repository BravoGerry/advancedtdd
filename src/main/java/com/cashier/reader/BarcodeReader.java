package com.cashier.reader;

public class BarcodeReader {
	private final Repository repository;

	public BarcodeReader(Repository repository) {

		this.repository = repository;
	}

	public String getPrice(String code) {
		return repository.getPriceBy(code);
	}
}
