package ru.awesome.shop.ta.product.pages;

import ru.awesome.shop.ta.framework.browser.Browser;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "index.php?route=common/home";

    public HomePage open() {
        Browser.getInstance().navigate(BASE_URL.concat(HOME_PAGE_URL));
        return this;
    }
}

