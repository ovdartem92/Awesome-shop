package ru.awesome.shop.ta.framework.ui.components;

import ru.awesome.shop.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Label extends CommonPageElement {

    public Label(By locator) {
        Objects.requireNonNull(locator, "Locator can not be null");
        this.locator = locator;
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }

    @Override
    public String toString() {
        String labelName = getText();
        return String.format("Label \"%s\"", labelName);
    }

    public boolean isDisplayed() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().isDisplayed(locator);
    }
}
