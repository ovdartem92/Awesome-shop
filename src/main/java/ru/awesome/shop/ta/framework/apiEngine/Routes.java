package ru.awesome.shop.ta.framework.apiEngine;

public class Routes {
    private static final String COMMON_PART = "/index.php?route=api/";
    private static final String GET_TOKEN = "login";
    private static final String ADD_ITEM = "cart/add";
    private static final String OPEN_CART = "cart/products";
    private static final String EDIT_CART = "cart/edit";
    private static final String REMOVE_ITEM = "cart/remove";
    private static final String USE_COUPON = "coupon";

    public static String getToken() {
        return COMMON_PART + GET_TOKEN;
    }

    public static String addItem() {
        return COMMON_PART + ADD_ITEM;
    }

    public static String openCart() {
        return COMMON_PART + OPEN_CART;
    }

    public static String editCart() {
        return COMMON_PART + EDIT_CART;
    }

    public static String removeItem() {
        return COMMON_PART + REMOVE_ITEM;
    }

    public static String useCoupon() {
        return COMMON_PART + USE_COUPON;
    }
}
