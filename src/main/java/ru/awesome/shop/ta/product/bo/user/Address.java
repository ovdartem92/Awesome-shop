package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Address {
    private String companyName;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String postCode;
    private String country;
    private String region;
}
