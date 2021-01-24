package ru.awesome.shop.ta.framework.apiEngine;

public class AddItemRequest {
    public String product_id;
    public String quantity;

    public AddItemRequest(String product_id, String quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
