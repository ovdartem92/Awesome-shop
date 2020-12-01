package net.skyscanner.ta.product.bo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
}
