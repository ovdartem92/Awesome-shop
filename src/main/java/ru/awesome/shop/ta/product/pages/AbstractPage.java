package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.WebDriver;


public class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
