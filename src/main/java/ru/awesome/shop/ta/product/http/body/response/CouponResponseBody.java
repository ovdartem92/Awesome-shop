package ru.awesome.shop.ta.product.http.body.response;

public class CouponResponseBody {
    private String error;

    public CouponResponseBody() {
    }

    public CouponResponseBody(String error) {
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
