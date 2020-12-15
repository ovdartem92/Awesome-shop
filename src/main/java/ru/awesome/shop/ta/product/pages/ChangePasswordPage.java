package ru.awesome.shop.ta.product.pages;

import org.openqa.selenium.By;
import ru.awesome.shop.ta.framework.ui.components.Button;
import ru.awesome.shop.ta.framework.ui.components.TextField;

public class ChangePasswordPage {
    private TextField passwordTextField = new TextField(By.xpath("//input[@name='password']"));
    private TextField confirmPasswordTextField = new TextField(By.xpath("//input[@name='confirm']"));
    private Button continueButton = new Button(By.xpath("//input[@value='Continue']"));

    public ChangePasswordPage typeToPasswordTextField(String password) {
        passwordTextField.type(password);
        return this;
    }

    public ChangePasswordPage typeToConfirmPasswordTextField(String password) {
        confirmPasswordTextField.type(password);
        return this;
    }

    public AccountPage clickOnContinueButton() {
        continueButton.click();
        return new AccountPage();
    }
}
