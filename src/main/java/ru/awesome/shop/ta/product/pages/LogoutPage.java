package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class LogoutPage {
    private Label logOutLabel = new Label(By.xpath("//h1[text()='Account Logout']"));

    public boolean isLogOutLabelDisplayed() {
        return logOutLabel.isDisplayed();
    }
}
