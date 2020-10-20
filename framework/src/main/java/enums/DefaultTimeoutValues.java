package enums;

public enum DefaultTimeoutValues {

    SHORT_TIMEOUT_MILLIS(500), LONG_TIMEOUT_SECONDS(15), DEFAULT_TIMEOUT_SECONDS(5);

    private int value;

    DefaultTimeoutValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
