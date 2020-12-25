package ru.awesome.shop.ta.product.pages;

import ru.awesome.shop.ta.framework.browser.Browser;

public class CheckoutPage extends BasePage {
    private static final String CHECKOUT_PAGE_URL = "index.php?route=checkout/checkout";

    public CheckoutPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(CHECKOUT_PAGE_URL));
        return this;
    }
}
