package ru.awesome.shop.ta.framework.exceptions;

public class IncorrectSearchCriteriaException extends IllegalArgumentException{

    public IncorrectSearchCriteriaException(String message) {
        super(message);
    }
}
