package ru.awesome.shop.ta.framework.exceptions;

public class RegistrationException extends RuntimeException {

    public RegistrationException(String errorMessage) {
        super(errorMessage);
    }
}
