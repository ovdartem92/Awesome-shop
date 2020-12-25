package ru.awesome.shop.ta.product.service;

import ru.awesome.shop.ta.product.pages.LaptopsCatalogPage;
import ru.awesome.shop.ta.product.pages.PhonesCatalogPage;

import java.util.List;

public class CatalogService {
    private PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();

    public void addPhonesToCart(List<String> phoneNames) {
        for (String name : phoneNames) {
            phonesCatalogPage.clickAddPhoneToCartButton(name);
        }
    }

    public void addLaptopsToCart(List<String> laptopNames) {
        for (String name : laptopNames) {
            laptopsCatalogPage.clickAddLaptopToCartButton(name);
        }
    }
}
