package com.cashier.reader;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashierTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private PriceRepository priceRepository = context.mock(PriceRepository.class);
	private Scanner scanner = context.mock(Scanner.class);
	private Display display = context.mock(Display.class);
	private Cashier cashier = new Cashier(priceRepository, display, scanner);

	@Test
	public void anInputOutput8Eur() throws Exception {
		context.checking(new Expectations() {{

			oneOf(scanner).scan();
			will(returnValue("001"));

			oneOf(priceRepository).getPriceBy("001");
			will(returnValue("8 Eur"));

			oneOf(display).show("8 Eur");

		}});

		cashier.findPrice();

	}


}
