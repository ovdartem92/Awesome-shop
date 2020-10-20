package service;

import enums.DefaultTimeoutValues;

import java.util.ResourceBundle;

import static enums.DefaultTimeoutValues.LONG_TIMEOUT_SECONDS;
import static enums.DefaultTimeoutValues.SHORT_TIMEOUT_MILLIS;
import static enums.DefaultTimeoutValues.DEFAULT_TIMEOUT_SECONDS;

public class TimeoutDataReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("timeout"));

    public static String getTimeoutData(String key) {
        return resourceBundle.getString(key);
    }

    public static int getTimeoutValue(DefaultTimeoutValues value) {
        switch (value) {
            case SHORT_TIMEOUT_MILLIS: {
                if (System.getProperty("timeout") == null)
                    return SHORT_TIMEOUT_MILLIS.getValue();
                return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.short"));
            }
            case LONG_TIMEOUT_SECONDS: {
                if (System.getProperty("timeout") == null)
                    return LONG_TIMEOUT_SECONDS.getValue();
                return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.long"));
            }
            case DEFAULT_TIMEOUT_SECONDS: {
                if (System.getProperty("timeout") == null)
                    return DEFAULT_TIMEOUT_SECONDS.getValue();
                return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.default"));
            }
            default: {
                return DEFAULT_TIMEOUT_SECONDS.getValue();
            }
        }
    }
}
