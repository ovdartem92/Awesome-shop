package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public final class PropertyReader {
    private static String PATH = "./src/main/resources/%s.properties";

    public static String getProperty(String propertyFileName, String key) {
        String value = null;
        Properties property = new Properties();

        try {
            Path path = Paths.get(String.format(PATH, "stage"));
            FileInputStream fis = new FileInputStream(path.toFile());
            property.load(fis);
            value = property.getProperty(key);
            if(value.isEmpty())
                throw new NullPointerException(String.format("Key '%s' is null or empty.", key));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getIntegerProperty(String propertyFileName, String key) {
        return Integer.parseInt(getProperty(propertyFileName, key));
    }
}
