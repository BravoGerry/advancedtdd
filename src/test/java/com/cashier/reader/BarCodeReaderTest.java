package com.cashier.reader;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarCodeReaderTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private Repository repository = context.mock(Repository.class);
	private BarcodeReader barcodeReader = new BarcodeReader(repository);

	@Test
	public void anInputOutput8Eur() throws Exception {
		context.checking(new Expectations() {{
			oneOf(repository).getPriceBy("001");
			will(returnValue("8 Eur"));
		}});
		assertEquals("8 Eur", barcodeReader.getPrice("001"));
	}


}
