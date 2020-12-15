package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.Link;

public class AccountPage {
    private Label myAccountLabel = new Label(By.xpath("//h2[text()='My Account']"));
    private Link changePasswordLink = new Link(By.xpath("//a[contains(text(),'Change')]"));

    public boolean isTextFromMyAccountLabelDisplayed() {
        return myAccountLabel.isDisplayed();
    }

    public ChangePasswordPage clickOnChangePasswordLink() {
        changePasswordLink.click();
        return new ChangePasswordPage();
    }
}
