package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.product.pages.AccountPage;

public class AccountService {

    public String getAccountName() {
        AccountPage accountPage = new AccountPage();
        return accountPage.getMyAccountName();
    }
}
