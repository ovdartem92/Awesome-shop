package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.BasePage;

public class LoginPage extends BasePage {
    private static final By EMAIL_TEXT_FIELD_LOCATOR = By.id("input-email");
    private static final By PASSWORD_TEXT_FIELD_LOCATOR = By.id("input-password");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@class='btn btn-primary']");
    private static final By WARNING_LABEL_LOCATOR = By.xpath("//div[contains(text(),'Warning')]");


    public LoginPage typeEmailAddress(String email) {
        new TextField(EMAIL_TEXT_FIELD_LOCATOR).type(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        new TextField(PASSWORD_TEXT_FIELD_LOCATOR).type(password);
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
        return new Label(WARNING_LABEL_LOCATOR).getText();
    }
}
