package ru.awesome.shop.ta.product.services;

import rp.org.apache.http.auth.AuthenticationException;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.LogoutPage;
import ru.awesome.shop.ta.product.pages.popups.AccountPopUp;

public class AuthenticationService {
    private LogoutPage logoutPage = new LogoutPage();

    public void login(String email, String password) throws AuthenticationException {
        LoginPage loginPage = new LoginPage();
        loginPage.typeEmailAddress(email);
        loginPage.typePassword(password);
        loginPage.clickLoginButton();
        if (loginPage.hasErrorMessage()) {
            throw new AuthenticationException("Authentication failed " + loginPage.getWarningMessage());
        }
    }

    public void logout() {
        AccountPage accountPage = new AccountPage();
        AccountPopUp accountPopUp = accountPage.clickMyAccountLink();
        accountPopUp.clickLogoutLink();
    }

    public String getBreadcrumbLogoutText() {
        return logoutPage.getBreadcrumbLogoutText();
    }

    public String getLogoutPageTitle() {
        return logoutPage.getPageTitle();
    }
}
