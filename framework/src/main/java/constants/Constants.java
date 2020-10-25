package constants;

import service.TestDataReader;

public final class Constants {
    public static String DOLLAR_SIGN = "$";
    public static String EURO_SIGN = "€";
    public static String ENGLISH_LANGUAGE = "en-US";
    public static String MOSCOW_SHEREMETYEVO_SVO = "Moscow Sheremetyevo (SVO)";
    public static String MOSCOW_VNUKOVO_VKO = "Moscow Vnukovo (VKO)";
    public static String MOSCOW = "Moscow";
    public static String TURIN = "Turin";
    public static int SHORT_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.short"));
    public static int LONG_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.long"));
    public static int DEFAULT_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.default"));
}
