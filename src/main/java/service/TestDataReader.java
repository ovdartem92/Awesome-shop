package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(System.getProperty("environment"));
    private static final ResourceBundle STAGE_BUNDLE = ResourceBundle.getBundle("stage");

    public static String getTestData(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }

    public static String getStageData(String key) {
        return STAGE_BUNDLE.getString(key);
    }

    public static int getIntStageData(String key) {
        return Integer.parseInt(getStageData(key));
    }
}
