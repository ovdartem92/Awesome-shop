package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        if (!"Your Store".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Home page");
        }
    }

    //общее для всех
    public String getPageTitle() {
        return driver.getTitle();
    }
}
