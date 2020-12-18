package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Credentials {
    private String email;
    private String password;
    private String passwordConfirm;
}
