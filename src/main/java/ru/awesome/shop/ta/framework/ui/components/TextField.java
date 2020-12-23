package ru.awesome.shop.ta.framework.ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void replaceWith(String text) {
        Objects.requireNonNull(text, "Text cannot be null");
        type(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public String getText() {
        String attribute = CommonPageElement.getAttribute(locator, "value");
        return attribute;
    }
}
