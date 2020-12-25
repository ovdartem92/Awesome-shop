package ru.awesome.shop.ta.product.service;

import rp.org.apache.http.auth.AuthenticationException;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.popups.AccountPopUp;

public class LoginService {

    public void login(String email, String password) throws AuthenticationException {
        LoginPage loginPage = new LoginPage();
        loginPage.typeEmailAddress(email);
        loginPage.typePassword(password);
        loginPage.clickLoginButton();
        if (loginPage.hasErrorMessage()) {
            throw new AuthenticationException("Authentication failed" + loginPage.getWarningMessage());
        }
    }

    public void logout() {
        AccountPage accountPage = new AccountPage();
        AccountPopUp accountPopUp = accountPage.clickMyAccountLink();
        accountPopUp.clickLogoutLink();
    }
}
