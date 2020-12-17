package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.BasePage;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage typePassword(String password) {
        final By PASSWORD_TEXT_FIELD_LOCATOR = By.xpath("//input[@name='password']");
        new TextField(PASSWORD_TEXT_FIELD_LOCATOR).type(password);
        return this;
    }

    public ChangePasswordPage typeConfirmationPassword(String password) {
        final By CONFIRM_PASSWORD_TEXT_FIELD_LOCATOR = By.xpath("//input[@name='confirm']");
        new TextField(CONFIRM_PASSWORD_TEXT_FIELD_LOCATOR).type(password);
        return this;
    }

    public AccountPage clickContinueButton() {
        final By CONTINUE_BUTTON_LOCATOR = By.xpath("//input[@value='Continue']");
        new Button(CONTINUE_BUTTON_LOCATOR).click();
        return new AccountPage();
    }
}
