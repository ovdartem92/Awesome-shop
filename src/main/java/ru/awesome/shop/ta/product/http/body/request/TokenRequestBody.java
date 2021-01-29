package ru.awesome.shop.ta.product.http.body.request;

public class TokenRequestBody {
    private String key;

    public TokenRequestBody() {
        this.key = "6faAsXOzZ8ENbDJnFwnPqMooM0JcTRXUdJ7FicMVjE7FcxZwMtZVbrsi63ZPrFKV7FzuaETay3GfsCCpwUMMqo1fyIHg8F42uMPbFFs8K4sDwIOaoQJZDYNBOzu83YLOFfzIOKuRoPJy8UZbYmCYnavSjT8DvSLSMxzLingdiPPMFTwFrao2pMBR1Vsv53VMe3hNUgAknBxFIv5QWt86LoXvnzIx2xZqOLQrrK4ZADKWYn5hEDqtN8IHEGYgmmsM";
    }

    public TokenRequestBody(String key, String value) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
