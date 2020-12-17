package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.BasePage;

public class AccountPage extends BasePage {

    public String getTextFromMyAccountLabel() {
        final By MY_ACCOUNT_LABEL_LOCATOR = By.xpath("//h2[text()='My Account']");
        return new Label(MY_ACCOUNT_LABEL_LOCATOR).getText();
    }

    public ChangePasswordPage clickChangePasswordLink() {
        final By CHANGE_PASSWORD_LINK_LOCATOR = By.xpath("//a[contains(text(),'Change')]");
        new Link(CHANGE_PASSWORD_LINK_LOCATOR).click();
        return new ChangePasswordPage();
    }
}
