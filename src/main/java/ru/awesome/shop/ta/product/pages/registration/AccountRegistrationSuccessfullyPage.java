package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class AccountRegistrationSuccessfullyPage {
    private Label accountCreationMessage = new Label(By.tagName("h1"));
    private Button continueButton = new Button(By.className("pull-right"));

    public String getAccountCreationMessage() {
        return accountCreationMessage.getText();
    }

    public AccountRegistrationSuccessfullyPage clickContinueButton() {
        continueButton.click();
        return this;
    }
}
