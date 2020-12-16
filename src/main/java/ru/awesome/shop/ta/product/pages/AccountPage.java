package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class AccountPage {
    private static final By MY_ACCOUNT_LABEL_LOCATOR = By.xpath("//h2[text()='My Account']");
    private static final By CHANGE_PASSWORD_LINK_LOCATOR = By.xpath("//a[contains(text(),'Change')]");

    public String getTextFromMyAccountLabel() {
        return new Label(MY_ACCOUNT_LABEL_LOCATOR).getText();
    }

    public ChangePasswordPage clickChangePasswordLink() {
        new Link(CHANGE_PASSWORD_LINK_LOCATOR).click();
        return new ChangePasswordPage();
    }
}
