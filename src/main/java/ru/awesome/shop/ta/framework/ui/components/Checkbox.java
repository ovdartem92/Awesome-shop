package ru.awesome.shop.ta.framework.ui.components;

import ru.awesome.shop.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Checkbox extends CommonPageElement {

    public Checkbox(By locator) {
        Objects.requireNonNull(locator, "Locator can not be null");
        this.locator = locator;
    }

    public void setSelected(boolean selected) {
        if (selected) {
            if (!isSelected()) {
                Browser.getInstance().click(locator);
            }
        } else {
            if (isSelected()) {
                Browser.getInstance().click(locator);
            }
        }
    }

    public boolean isSelected() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().isSelected(locator);
    }
}
