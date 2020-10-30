package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle;

    public static String getTestData(String key) {
        resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
        return resourceBundle.getString(key);
    }

    public static String getStageData(String key) {
        resourceBundle = ResourceBundle.getBundle("stage");
        return resourceBundle.getString(key);
    }

    public static int getIntStageData(String key) {
        return Integer.parseInt(getStageData(key));
    }
}
