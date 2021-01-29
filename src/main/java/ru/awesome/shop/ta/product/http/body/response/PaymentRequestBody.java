package ru.awesome.shop.ta.product.http.body.response;

public class PaymentRequestBody {
    private String paymentMethod;

    public PaymentRequestBody( ) {
        this.paymentMethod = "free_checkout";
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
