package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.BasePage;

public class LoginPage extends BasePage {
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@class='btn btn-primary']");

    public LoginPage typeEmailAddress(String email) {
        By emailTextFieldLocator = By.id("input-email");
        new TextField(emailTextFieldLocator).type(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        By passwordTextFieldLocator = By.id("input-password");
        new TextField(passwordTextFieldLocator).type(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        new Button(LOGIN_BUTTON_LOCATOR).click();
        return new AccountPage();
    }

    public LoginPage clickLoginButtonExpectingFailure() {
        new Button(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

    public String getTextWarningMessage() {
        By warningLabelLocator = By.xpath("//div[contains(text(),'Warning')]");
        return new Label(warningLabelLocator).getText();
    }
}
