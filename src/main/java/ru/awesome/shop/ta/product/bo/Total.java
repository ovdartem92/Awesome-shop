package ru.awesome.shop.ta.product.bo;

public class Total {
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Total{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
