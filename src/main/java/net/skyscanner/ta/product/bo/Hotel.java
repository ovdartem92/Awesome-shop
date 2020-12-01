package net.skyscanner.ta.product.bo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Hotel {
    private String name;
    private double rating;
    private int price;
}
