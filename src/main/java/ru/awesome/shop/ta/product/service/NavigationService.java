package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.product.pages.*;

public class NavigationService {
    private LoginPage loginPage = new LoginPage();
    private AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private CartPage cartPage = new CartPage();
    private PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();

    public void navigateToLoginPage() {
        loginPage.open();
    }

    public void navigateToAccountRegistrationPage() {
        accountRegistrationPage.open();
    }

    public void navigateToCartPage() {
        cartPage.open();
    }

    public void navigateToPhonesCatalogPage() {
        phonesCatalogPage.open();
    }

    public void navigateToLaptopsCatalogPage() {
        laptopsCatalogPage.open();
    }
}
