package com.cashier.reader;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class AutomaticPointOfSaleTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private Catalog catalog = context.mock(Catalog.class);
    private BarCodeReader barCodeReader = context.mock(BarCodeReader.class);
    private Cart cart = context.mock(Cart.class);
    private Display display = context.mock(Display.class);
    private PointOfSale pointOfSale = new AutomaticPointOfSale(barCodeReader, catalog, cart, display);

    @Test
    public void anInputOutput8Eur() throws Exception {
        final Product productFound = aProduct("001", new Price(BigDecimal.TEN, "Eur"));
        context.checking(new Expectations() {{
            oneOf(barCodeReader).shot();
            will(returnValue("001"));
            oneOf(catalog).getProduct("001");
            will(returnValue(productFound));
            oneOf(cart).add(productFound);
            oneOf(cart).getAll();
            will(returnValue(Arrays.asList(productFound)));
            oneOf(display).show(with(samePrice(new Price(BigDecimal.TEN, "Eur"))));
        }});
        pointOfSale.acquire();
        pointOfSale.total();

    }

    private Matcher<Price> samePrice(final Price price) {
        return new BaseMatcher<Price>() {
            @Override
            public boolean matches(Object object) {
                Price orPrice = (Price) object;
                return orPrice.getAmount().compareTo(price.getAmount()) == 0
                        &&
                        orPrice.getCurrency().equals(price.getCurrency());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("getNumber should return ").appendValue(price);
            }
        };
    }

    private Product aProduct(String code, Price price) {
        return new Product(code, price);
    }


}
