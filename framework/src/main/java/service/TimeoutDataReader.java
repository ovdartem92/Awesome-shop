package service;

import java.util.ResourceBundle;

public class TimeoutDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("timeout"));

    public static String getTimeoutData(String key) {
        return resourceBundle.getString(key);
    }
}
