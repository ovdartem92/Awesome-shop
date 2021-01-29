package ru.awesome.shop.ta.product.http.body.request;

public class AddItemRequestBody {
    private int product_id;
    private int quantity;

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public AddItemRequestBody(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddItemRequestBody{" +
                "product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
