package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class AccountPage extends BasePage {

    public String getMyAccountName() {
        By myAccountLabelLocator = By.xpath("//h2[text()='My Account']");
        Label myAccountLabel = new Label(myAccountLabelLocator);
        return myAccountLabel.getText();
    }

    public ChangePasswordPage clickChangePasswordLink() {
        By changePasswordLinkLocator = By.xpath("//a[contains(text(),'Change')]");
        Link changePasswordLink = new Link(changePasswordLinkLocator);
        changePasswordLink.click();
        return new ChangePasswordPage();
    }
}
