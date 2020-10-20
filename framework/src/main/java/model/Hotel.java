package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
public class Hotel {

    private String name;
    private double rating;
    private int price;
}
