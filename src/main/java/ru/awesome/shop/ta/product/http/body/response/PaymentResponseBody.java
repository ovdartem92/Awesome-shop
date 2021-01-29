package ru.awesome.shop.ta.product.http.body.response;

public class PaymentResponseBody {
    private String error;
    private String success;

    public PaymentResponseBody() {
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }
}
