package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.Label;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class LoginPage {
    private TextField emailAddressTextField = new TextField(By.id("input-email"));
    private TextField passwordTextField = new TextField(By.id("input-password"));
    private Button loginButton = new Button(By.xpath("//input[@class='btn btn-primary']"));
    private Label warningLabel = new Label(By.xpath("//div[contains(text(),'Warning')]"));

    public LoginPage typeEmailAddress(String email) {
        emailAddressTextField.type(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTextField.type(password);
        return this;
    }

    public AccountPage clickOnLoginButton() {
        loginButton.click();
        return new AccountPage();
    }

    public LoginPage clickOnLoginButtonWithInvalidCredentials() {
        loginButton.click();
        return this;
    }

    public boolean isWarningMessageDisplayed() {
        return warningLabel.isDisplayed();
    }
}
