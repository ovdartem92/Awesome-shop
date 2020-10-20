package service;

import java.util.ResourceBundle;

public class TimeoutDataReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("timeout"));

    public static String getTimeoutData(String key) {

        return resourceBundle.getString(key);

    }

    enum DefaultTimeoutValues {
        SHORT_TIMEOUT_MILLIS("500"), LONG_TIMEOUT_SECONDS("15"),
        DEFAULT_TIMEOUT_SECONDS("5");

        private String name;

        DefaultTimeoutValues(String name) {
            this.name = name;
        }
    }
}
