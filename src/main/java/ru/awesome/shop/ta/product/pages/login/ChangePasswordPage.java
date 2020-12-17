package ru.awesome.shop.ta.product.pages.login;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;
import ru.awesome.shop.ta.product.pages.BasePage;

public class ChangePasswordPage extends BasePage {
    private static final By PASSWORD_TEXT_FIELD_LOCATOR = By.xpath("//input[@name='password']");
    private static final By CONFIRM_PASSWORD_TEXT_FIELD_LOCATOR = By.xpath("//input[@name='confirm']");
    private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//input[@value='Continue']");

    public ChangePasswordPage typePassword(String password) {
        new TextField(PASSWORD_TEXT_FIELD_LOCATOR).type(password);
        return this;
    }

    public ChangePasswordPage typeConfirmationPassword(String password) {
        new TextField(CONFIRM_PASSWORD_TEXT_FIELD_LOCATOR).type(password);
        return this;
    }

    public AccountPage clickContinueButton() {
        new Button(CONTINUE_BUTTON_LOCATOR).click();
        return new AccountPage();
    }
}
