package ru.awesome.shop.ta.product.http.body.request;

public class TokenRequestBody {
    public String username;
    public String key;

    public TokenRequestBody() {
        this.username = "Autotest";
        this.key = "6faAsXOzZ8ENbDJnFwnPqMooM0JcTRXUdJ7FicMVjE7FcxZwMtZVbrsi63ZPrFKV7FzuaETay3GfsCCpwUMMqo1fyI" +
                "Hg8F42uMPbFFs8K4sDwIOaoQJZDYNBOzu83YLOFfzIOKuRoPJy8UZbYmCYnavSjT8DvSLSMxzLingdiPPMFTwFrao2pMBR1Vsv" +
                "53VMe3hNUgAknBxFIv5QWt86LoXvnzIx2xZqOLQrrK4ZADKWYn5hEDqtN8IHEGYgmmsM";
    }

    public TokenRequestBody(String username, String key) {
        this.key = key;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }
}
