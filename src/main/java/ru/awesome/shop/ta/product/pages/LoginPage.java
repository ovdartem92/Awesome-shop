package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class LoginPage extends BasePage {
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@class='btn btn-primary']");
    private static final Button LOGIN_BUTTON = new Button(LOGIN_BUTTON_LOCATOR);
    private static final String URL = "https://awesome-shop.01sh.ru/index.php?route=account/login";

    public LoginPage open() {
        Browser.getInstance().navigate(URL);
        return new LoginPage();
    }

    public LoginPage typeEmailAddress(String email) {
        By emailTextFieldLocator = By.id("input-email");
        TextField emailTextField = new TextField(emailTextFieldLocator);
        emailTextField.type(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        By passwordTextFieldLocator = By.id("input-password");
        TextField passwordTextField = new TextField(passwordTextFieldLocator);
        passwordTextField.type(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        LOGIN_BUTTON.click();
        return new AccountPage();
    }

    public LoginPage clickLoginButtonExpectingFailure() {
        LOGIN_BUTTON.click();
        return this;
    }

    public String getWarningMessage() {
        By warningLabelLocator = By.xpath("//div[contains(text(),'Warning')]");
        Label warningLabel = new Label(warningLabelLocator);
        return warningLabel.getText();
    }
}
