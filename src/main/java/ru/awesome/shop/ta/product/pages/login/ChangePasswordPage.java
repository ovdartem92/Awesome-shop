package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.BasePage;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage typePassword(String password) {
        By passwordTextFieldLocator = By.xpath("//input[@name='password']");
        new TextField(passwordTextFieldLocator).type(password);
        return this;
    }

    public ChangePasswordPage typeConfirmationPassword(String password) {
        By confirmPasswordTextFieldLocator = By.xpath("//input[@name='confirm']");
        new TextField(confirmPasswordTextFieldLocator).type(password);
        return this;
    }

    public AccountPage clickContinueButton() {
        By continueButtonLocator = By.xpath("//input[@value='Continue']");
        new Button(continueButtonLocator).click();
        return new AccountPage();
    }
}
