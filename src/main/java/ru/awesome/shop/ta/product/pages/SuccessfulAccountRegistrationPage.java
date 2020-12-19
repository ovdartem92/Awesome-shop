package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;

public class SuccessfulAccountRegistrationPage extends BasePage {

    public String getAccountCreationMessage() {
        By accountCreationMessageLocator = By.tagName("h1");
        Label accountCreationMessage = new Label(accountCreationMessageLocator);
        return accountCreationMessage.getText();
    }

    public SuccessfulAccountRegistrationPage clickContinueButton() {
        By continueButtonLocator = By.className("pull-right");
        Button continueButton = new Button(continueButtonLocator);
        continueButton.click();
        return this;
    }
}
