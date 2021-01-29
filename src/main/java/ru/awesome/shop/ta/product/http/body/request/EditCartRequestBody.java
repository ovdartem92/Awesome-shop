package ru.awesome.shop.ta.product.http.body.request;

public class EditCartRequestBody {
    private int key;
    private int quantity;

    public EditCartRequestBody(int key, int quantity) {
        this.key = key;
        this.quantity =quantity;
    }

    public int getKey() {
        return key;
    }

    public int getQuantity() {
        return quantity;
    }
}
