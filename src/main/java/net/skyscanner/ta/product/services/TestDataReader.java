package net.skyscanner.ta.product.services;

import java.util.ResourceBundle;

/**
 * This class is used to get values from properties files.
 */
public final class TestDataReader {
    private TestDataReader() {
    }

    /**
     * The method is required to read a property from the properties file specified in the system environment variable.
     *
     * @param key set the required property
     * @return value of the specified property
     */
    public static String getTestData(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
        return resourceBundle.getString(key);
    }

    /**
     * The method is required to read a property from the properties file specified in the system environment variable.
     * If no properties are found by the specified key, then the method will return the default value.
     *
     * @param key      set the required property
     * @param defValue set the default property
     * @return value of the specified property or default value, if the property was not found
     */
    public static String getTestData(String key, String defValue) {
        try {
            return getTestData(key);
        } catch (NullPointerException e) {
            return defValue;
        }
    }

    /**
     * The method is used to read properties by key from a stage file
     * <a href="file:src/main/resources/stage.properties">stage.properties</a>.
     *
     * @param key set the required property
     * @return value of the specified property
     */
    public static String getStageData(String key) {
        ResourceBundle stageBundle = ResourceBundle.getBundle("stage");
        return stageBundle.getString(key);
    }

    /**
     * The method is used to read properties by key from a stage file
     * <a href="file:src/main/resources/stage.properties">stage.properties</a>.
     *
     * @param key set the required property
     * @return Integer value of the specified property
     */
    public static int getIntStageData(String key) {
        return Integer.parseInt(getStageData(key));
    }
}
