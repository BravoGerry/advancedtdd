package com.cashier.reader;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CashierTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();

	@Mock
	private Catalog catalog;
	@Mock
	private Scanner scanner;
	@Mock
	private Display display;

	Cashier cashier;

	@Before
	public void setUp() {
		cashier = new Cashier(catalog, display, scanner);
	}


	@Test
	public void twoItemsNotOntario() throws Exception {


		final Product product1 = new Product("001", 8.0, false);
		final Product product2 = new Product("002", 3.0, true);

		context.checking(new Expectations() {{
			oneOf(scanner).scan();
			will(returnValue("001"));

			oneOf(scanner).scan();
			will(returnValue("002"));

			oneOf(catalog).get("001");
			will(returnValue(product1));

			oneOf(catalog).get("002");
			will(returnValue(product2));

			oneOf(display).show("8.00 G");
			oneOf(display).show("3.00 GP");
		}});
		cashier.acquire();
		cashier.acquire();

	}


}
