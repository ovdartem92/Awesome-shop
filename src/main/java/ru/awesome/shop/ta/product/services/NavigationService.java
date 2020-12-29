package ru.awesome.shop.ta.product.services;

import ru.awesome.shop.ta.product.pages.*;

public class NavigationService {
    private LoginPage loginPage = new LoginPage();
    private AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private CartPage cartPage = new CartPage();
    private PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();
    private HomePage homePage = new HomePage();
    private CheckoutPage checkoutPage = new CheckoutPage();

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

    public void navigateToHomePage() {
        homePage.open();
    }

    public void navigateToCheckoutPage() {
        checkoutPage.open();
    }
}
