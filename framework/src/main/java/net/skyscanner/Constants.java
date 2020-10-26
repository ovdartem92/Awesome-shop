package net.skyscanner;

import net.skyscanner.service.TestDataReader;

public final class Constants {
    public static final String DOLLAR_SIGN = "$";
    public static final String EURO_SIGN = "€";
    public static final String ENGLISH_LANGUAGE = "en-US";
    public static final String MOSCOW_SHEREMETYEVO_SVO = "Moscow Sheremetyevo (SVO)";
    public static final String MOSCOW_VNUKOVO_VKO = "Moscow Vnukovo (VKO)";
    public static final String MOSCOW = "Moscow";
    public static final String TURIN = "Turin";
    public static int SHORT_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.short"));
    public static int LONG_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.long"));
    public static int DEFAULT_TIMEOUT_SECONDS = Integer.parseInt(TestDataReader.getTestData("timeout.default"));
}
