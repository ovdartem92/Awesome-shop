package ru.awesome.shop.ta.product.bo;

import java.util.List;

public class Product {

    private int cart_id;
    private int product_id;
    private String name;
    private String model;
    private List<Object> option = null;
    private int quantity;
    private Boolean stock;
    private String shipping;
    private String price;
    private String total;
    private Integer reward;

    public int getCart_id() {
        return cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public List<Object> getOption() {
        return option;
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean getStock() {
        return stock;
    }

    public String getShipping() {
        return shipping;
    }

    public String getPrice() {
        return price;
    }

    public String getTotal() {
        return total;
    }

    public Integer getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cart_id='" + cart_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", option=" + option +
                ", quantity='" + quantity + '\'' +
                ", stock=" + stock +
                ", shipping='" + shipping + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                ", reward=" + reward +
                '}';
    }
}
