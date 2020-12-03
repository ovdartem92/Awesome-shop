package net.skyscanner.ta.framework.ui.components;

import net.skyscanner.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class Checkbox extends CommonPageElement {
    public Checkbox(By locator) {
        Objects.requireNonNull(locator, "Locator can not be null");
        this.locator = locator;
    }

    public void setSelected() {
        if (!isSelected()) {
            Browser.getInstance().clear(locator);
        }
    }

    public boolean isSelected() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().isSelected(locator);
    }
}
