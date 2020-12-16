package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class AccountRegistrationSuccessfullyScreen {
    private Label accountCreatedLabel = new Label(By.tagName("h1"));
    private Button continueButton = new Button(By.className("pull-right"));

    public String getAccountCreatedLabelText() {
        return accountCreatedLabel.getText();
    }

    public AccountRegistrationSuccessfullyScreen clickContinueButton() {
        continueButton.click();
        return this;
    }
}
