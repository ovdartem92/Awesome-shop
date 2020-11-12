package service;

import java.util.ResourceBundle;

public class TestDataReader {

    public static String getTestData(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
        return resourceBundle.getString(key);
    }

    public static String getTestData(String key, String defValue) {
        try {
            return getTestData(key);
        } catch (NullPointerException e) {
            return defValue;
        }
    }

    public static String getStageData(String key) {
        ResourceBundle stageBundle = ResourceBundle.getBundle("stage");
        return stageBundle.getString(key);
    }

    public static int getIntStageData(String key) {
        return Integer.parseInt(getStageData(key));
    }
}
