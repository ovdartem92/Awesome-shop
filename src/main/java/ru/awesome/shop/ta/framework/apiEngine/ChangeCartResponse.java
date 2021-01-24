package ru.awesome.shop.ta.framework.apiEngine;

public class ChangeCartResponse {
    private String success;

    public ChangeCartResponse() {
    }

    public ChangeCartResponse(String success) {
        super();
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
