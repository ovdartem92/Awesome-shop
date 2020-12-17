package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;
import ru.awesome.shop.ta.product.pages.BasePage;

public class AccountPage extends BasePage {

    public String getTextFromMyAccountLabel() {
        By myAccountLabelLocator = By.xpath("//h2[text()='My Account']");
        return new Label(myAccountLabelLocator).getText();
    }

    public ChangePasswordPage clickChangePasswordLink() {
        By changePasswordLinkLocator = By.xpath("//a[contains(text(),'Change')]");
        new Link(changePasswordLinkLocator).click();
        return new ChangePasswordPage();
    }
}
