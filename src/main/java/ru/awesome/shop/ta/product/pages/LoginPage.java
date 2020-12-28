package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

import static ru.awesome.shop.ta.framework.ui.components.CommonPageElement.isElementVisible;

public class LoginPage extends BasePage {
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@class='btn btn-primary']");
    private static final String LOGIN_PAGE_URL = "index.php?route=account/login";

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
        Button loginButton = new Button(LOGIN_BUTTON_LOCATOR);
        loginButton.click();
        return new AccountPage();
    }

    public LoginPage clickLoginButtonExpectingFailure() {
        Button loginButton = new Button(LOGIN_BUTTON_LOCATOR);
        loginButton.click();
        return this;
    }

    public String getWarningMessage() {
        By warningLabelLocator = By.xpath("//div[contains(text(),'Warning')]");
        Label warningLabel = new Label(warningLabelLocator);
        return warningLabel.getText();
    }

    public LoginPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(LOGIN_PAGE_URL));
        return new LoginPage();
    }

    public boolean hasErrorMessage() {
        By errorMessageLocator = By.xpath("//div[contains(text(),'Warning')]");
        final int timeoutInSeconds = 2;
        return isElementVisible(errorMessageLocator, timeoutInSeconds);
    }
}
