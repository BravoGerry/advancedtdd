package com.cashier.reader;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CashierTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private Catalog catalog = context.mock(Catalog.class);
	private Scanner scanner = context.mock(Scanner.class);
	private Display display = context.mock(Display.class);
	private Cashier cashier = new Cashier(catalog, display, scanner);

	@Test
	public void twoItems() throws Exception {
		context.checking(new Expectations() {{

			oneOf(scanner).scan(); will(returnValue("001"));
			oneOf(scanner).scan(); will(returnValue("002"));
			oneOf(catalog).getPriceBy("001"); will(returnValue(8.0));
			oneOf(catalog).getPriceBy("002"); will(returnValue(3.0));

			oneOf(display).show("11.00 EUR");
		}});

		cashier.acquire();
		cashier.acquire();

		cashier.sell();

	}


}
