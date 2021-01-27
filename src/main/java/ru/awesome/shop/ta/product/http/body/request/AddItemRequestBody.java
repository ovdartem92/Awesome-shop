package ru.awesome.shop.ta.product.http.body.request;

public class AddItemRequestBody {
    int product_id;
    int quantity;

    public AddItemRequestBody(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
