package ru.awesome.shop.ta.framework.ui.components;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;

import java.util.Objects;

public class TextField extends CommonPageElement {

    public TextField(By locator) {
        Objects.requireNonNull(locator, "Locator can not be null");
        this.locator = locator;
    }

    public void clear() {
        waitForPageElementVisibilityLocated(locator);
        Browser.getInstance().clear(locator);
    }

    public void type(CharSequence... textForType) {
        Objects.requireNonNull(textForType, "Text can not be null");
        waitForPageElementPresenceLocated(locator);
        Browser.getInstance().sendKeys(locator, textForType);
    }

    public String getText() {
        String attribute = CommonPageElement.getAttribute(locator, "value");
        return attribute;
    }
}
