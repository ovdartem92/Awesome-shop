package ru.awesome.shop.ta.framework.ui.components;

import ru.awesome.shop.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Link extends CommonPageElement {

    public Link(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        this.locator = locator;
    }

    public void click() {
        waitForPageElementToBeClickable(locator);
        Browser.getInstance().click(locator);
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }
}
