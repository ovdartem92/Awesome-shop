package ru.awesome.shop.ta.product.http.body.request;

public class RemoveItemRequestBody {
    private int key;

    public RemoveItemRequestBody(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
