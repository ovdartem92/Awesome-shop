package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class ChangePasswordPage extends BasePage {
    private static final String CHANGE_PASSWORD_PAGE_URL = "index.php?route=account/password";

    public ChangePasswordPage typePassword(String password) {
        By passwordTextFieldLocator = By.xpath("//input[@name='password']");
        TextField passwordTextField = new TextField(passwordTextFieldLocator);
        passwordTextField.type(password);
        return this;
    }

    public ChangePasswordPage typeConfirmationPassword(String password) {
        By confirmPasswordTextFieldLocator = By.xpath("//input[@name='confirm']");
        TextField confirmPasswordTextField = new TextField(confirmPasswordTextFieldLocator);
        confirmPasswordTextField.type(password);
        return this;
    }

    public AccountPage clickContinueButton() {
        By continueButtonLocator = By.xpath("//input[@value='Continue']");
        Button continueButton = new Button(continueButtonLocator);
        continueButton.click();
        return new AccountPage();
    }

    public ChangePasswordPage open() {
        Browser.getInstance().navigate(BASE_URL.concat(CHANGE_PASSWORD_PAGE_URL));
        return this;
    }
}

