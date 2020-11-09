package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String city;
}
