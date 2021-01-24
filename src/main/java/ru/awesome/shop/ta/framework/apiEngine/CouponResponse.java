package ru.awesome.shop.ta.framework.apiEngine;

public class CouponResponse {
    private String error;

    public CouponResponse() {
    }

    public CouponResponse(String error) {
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "CouponResponse{" +
                "error='" + error + '\'' +
                '}';
    }
}
