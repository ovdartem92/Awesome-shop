package ru.awesome.shop.ta.product.http.body.response;

public class ChangeCartResponseBody {
    private String success;

    public ChangeCartResponseBody() {
    }

    public ChangeCartResponseBody(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "AddItemResponse{" +
                "success='" + success + '\'' +
                '}';
    }
}
