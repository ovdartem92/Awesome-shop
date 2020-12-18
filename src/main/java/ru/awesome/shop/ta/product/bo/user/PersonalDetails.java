package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String faxNumber;
}
