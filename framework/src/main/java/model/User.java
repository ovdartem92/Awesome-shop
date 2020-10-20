package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
public class User {
    private String email;
    private String password;
}
