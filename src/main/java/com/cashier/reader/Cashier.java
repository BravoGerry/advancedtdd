package com.cashier.reader;

public class Cashier {
	private final PriceRepository repository;
	private final Display display;
	private final Scanner scanner;

	public Cashier(PriceRepository priceRepository, Display display, Scanner scanner) {

		repository = priceRepository;
		this.display = display;
		this.scanner = scanner;
	}

	public void findPrice() {
		final String code = scanner.scan();
		final String price = repository.getPriceBy(code);
		display.show(price);
	}
}
