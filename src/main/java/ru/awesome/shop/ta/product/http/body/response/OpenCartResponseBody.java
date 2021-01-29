package ru.awesome.shop.ta.product.http.body.response;

import ru.awesome.shop.ta.product.bo.Product;
import ru.awesome.shop.ta.product.bo.Total;

import java.util.List;

public class OpenCartResponseBody {
    private List<Product> products = null;
    private List<Object> vouchers = null;
    private List<Total> totals = null;

    public List<Product> getProducts() {
        return products;
    }

    public List<Object> getVouchers() {
        return vouchers;
    }

    public List<Total> getTotals() {
        return totals;
    }

    @Override
    public String toString() {
        return "ItemResponse{" +
                "products=" + products +
                ", vouchers=" + vouchers +
                ", totals=" + totals +
                '}';
    }
}
