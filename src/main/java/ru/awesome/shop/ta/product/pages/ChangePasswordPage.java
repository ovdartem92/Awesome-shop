package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class ChangePasswordPage extends BasePage {

    public ChangePasswordPage open() {
        Browser.getInstance().navigate("https://awesome-shop.01sh.ru/index.php?route=account/password");
        return new ChangePasswordPage();
    }

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
}
