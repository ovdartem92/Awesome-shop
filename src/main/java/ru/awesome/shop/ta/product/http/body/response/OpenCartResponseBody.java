package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.product.bo.Product;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.List;
import java.util.Objects;

public class OpenCartResponseBody {
    private List<Product> products;
    private List<Object> vouchers;
    private List<Object> totals;

    public OpenCartResponseBody() {
    }

    public OpenCartResponseBody(List<Product> products, List<Object> vouchers, List<Object> totals) {
        Objects.requireNonNull(products, "Products cannot be null");
        Objects.requireNonNull(vouchers, "Vouchers cannot be null");
        Objects.requireNonNull(totals, "Totals cannot be null");
        this.products = products;
        this.vouchers = vouchers;
        this.totals = totals;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Object> getVouchers() {
        return vouchers;
    }

    public List<Object> getTotals() {
        return totals;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 79;
        final int secondPrime = 13;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(products)
                .append(vouchers)
                .append(totals)
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
        OpenCartResponseBody other = (OpenCartResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(products, other.products)
                .append(vouchers, other.vouchers)
                .append(totals, other.totals)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
