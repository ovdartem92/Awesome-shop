package service;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle= ResourceBundle.getBundle(System.getProperty("environment"));
    private static String STAGE_PATH = "./src/main/resources/stage.properties";

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    public static String getStageData(String key) {
        Properties property = new Properties();
        try (InputStream input = new FileInputStream(STAGE_PATH)) {
            property.load(input);
            if (property.getProperty(key).isEmpty())
                throw new NullPointerException(String.format("Property key '%s' is null or empty.", key));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property.getProperty(key);
    }

    public static int getIntegerStageData(String key) {
        return Integer.parseInt(getStageData(key));
    }
}
