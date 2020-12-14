package ru.awesome.shop.ta.framework.ui.components;

import ru.awesome.shop.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class DropDownList extends CommonPageElement {

    public DropDownList(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        this.locator = locator;
    }

    public void select(String option) {
        Objects.requireNonNull(option, "Option cannot be null.");
        waitForPageElementVisibilityLocated(locator);
        Browser.getInstance().select(locator, option);
    }

    public String getFirstSelectedOption() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getFirstSelectedOption(locator);
    }
}
