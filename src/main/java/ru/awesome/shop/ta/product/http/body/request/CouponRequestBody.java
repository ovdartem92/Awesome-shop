package ru.awesome.shop.ta.product.http.body.request;

public class CouponRequestBody {
    private int coupon;

    public int getCoupon() {
        return coupon;
    }

    public CouponRequestBody(int coupon) {
        this.coupon = coupon;
    }
}
