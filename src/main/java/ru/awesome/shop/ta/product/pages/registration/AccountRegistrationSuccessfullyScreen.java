package ru.awesome.shop.ta.product.pages.registration;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class AccountRegistrationSuccessfullyScreen {
    private final By accountCreatedLabelBy = By.tagName("h1");
    private final By continueButtonBy = By.className("pull-right");

    public String getAccountCreatedLabelText() {
        Label accountCreatedLabel = new Label(accountCreatedLabelBy);
        return accountCreatedLabel.getText();
    }

    public AccountRegistrationSuccessfullyScreen continueButtonClick() {
        Button continueButton = new Button(continueButtonBy);
        continueButton.click();
        return this;
    }
}
