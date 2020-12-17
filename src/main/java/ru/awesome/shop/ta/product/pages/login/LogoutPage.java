package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.product.pages.BasePage;

public class LogoutPage extends BasePage {
    private Label logOutLabel = new Label(By.xpath("//h1[text()='Account Logout']"));

    public String getLogOutLabelText() {
        return logOutLabel.getText();
    }
}
