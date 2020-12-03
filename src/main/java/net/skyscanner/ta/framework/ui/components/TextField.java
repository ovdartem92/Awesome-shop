package net.skyscanner.ta.framework.ui.components;

import net.skyscanner.ta.framework.browser.Browser;
import org.openqa.selenium.By;

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
        waitForPageElementPresenceLocated(locator);
        Browser.getInstance().sendKeys(locator, textForType);
    }
}
