package ru.awesome.shop.ta.product.bo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

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
        return JsonRepresentation.convertToJson(this);
    }
}
