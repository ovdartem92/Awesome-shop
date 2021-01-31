package ru.awesome.shop.ta.product.bo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.List;
import java.util.Objects;

public class Product {
    private int cart_id; //NOSONAR
    private int product_id; //NOSONAR
    private String name;
    private String model;
    private List<Object> option;
    private int quantity;
    private boolean stock;
    private String shipping;
    private String price;
    private String total;
    private int reward;

    public Product() {
    }

    public Product(int cartId, int productId, String name, String model, List<Object> option, int quantity,
                   boolean stock, String shipping, String price, String total, int reward) {
        Objects.requireNonNull(name, "Product name cannot be null");
        Objects.requireNonNull(model, "Product model cannot be null");
        Objects.requireNonNull(option, "Product option cannot be null");
        Objects.requireNonNull(shipping, "Shipping cannot be null");
        Objects.requireNonNull(price, "Product price cannot be null");
        Objects.requireNonNull(total, "Total cannot be null");
        this.cart_id = cartId;
        this.product_id = productId;
        this.name = name;
        this.model = model;
        this.option = option;
        this.quantity = quantity;
        this.stock = stock;
        this.shipping = shipping;
        this.price = price;
        this.total = total;
        this.reward = reward;
    }

    public int getCart_id() { //NOSONAR
        return cart_id;
    }

    public int getProduct_id() { //NOSONAR
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

    public boolean getStock() {
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

    public int getReward() {
        return reward;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 11;
        final int secondPrime = 53;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(cart_id)
                .append(product_id)
                .append(name)
                .append(model)
                .append(option)
                .append(quantity)
                .append(stock)
                .append(shipping)
                .append(price)
                .append(total)
                .append(reward)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(cart_id, other.cart_id)
                .append(product_id, other.product_id)
                .append(name, other.name)
                .append(model, other.model)
                .append(option, other.option)
                .append(quantity, other.quantity)
                .append(stock, other.stock)
                .append(shipping, other.shipping)
                .append(price, other.price)
                .append(total, other.total)
                .append(reward, other.reward)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
