package ru.awesome.shop.ta.service;

import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;

public class LoginService {
    private AccountPage accountPage = new AccountPage();

    public void login(String email, String password) {
        new LoginPage().clickMyAccountLink()
                .clickLoginLink()
                .typeEmailAddress(email)
                .typePassword(password)
                .clickLoginButton();
    }

    public void logout() {
        accountPage.clickMyAccountLink().clickLogoutLink();
    }

    public void changePassword(String newPassword) {
        accountPage.clickChangePasswordLink()
                .typePassword(newPassword)
                .typeConfirmationPassword(newPassword)
                .clickContinueButton();
    }
}
