package net.skyscanner.ta.framework.ui.components;

import lombok.Getter;
import lombok.Setter;
import net.skyscanner.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class RadioButton extends CommonPageElement {
    @Getter
    @Setter
    private RadioButtonGroup group;

    public RadioButton(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        this.locator = locator;
    }

    public boolean isSelected() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().isSelected(locator);
    }

    public void click() {
        waitForPageElementToBeClickable(locator);
        Browser.getInstance().click(locator);
    }

    public String getText() {
        waitForPageElementVisibilityLocated(locator);
        return Browser.getInstance().getText(locator);
    }

    @Override
    public String toString() {
        String radioButtonName = getText();
        return String.format("Radio Button \"%s\"", radioButtonName);
    }
}
