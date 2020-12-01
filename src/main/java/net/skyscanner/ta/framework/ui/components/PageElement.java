package net.skyscanner.ta.framework.ui.components;

import org.openqa.selenium.internal.WrapsElement;

public interface PageElement extends WrapsElement {
    boolean isDisplay();
    boolean isEnabled();
    boolean isSelected();
    String getText();
    void click();
    void clear();
    void sendKeys(CharSequence... keysToSend);
}
