package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private String email;
    private String password;
}
