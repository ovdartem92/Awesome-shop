package constants;

import service.TimeoutDataReader;

public final class Constants {
    public static String DOLLAR_SIGN = "$";
    public static String EURO_SIGN = "€";
    public static String ENGLISH_LANGUAGE = "en-US";
    public static String MOSCOW_SHEREMETYEVO_SVO = "Moscow Sheremetyevo (SVO)";
    public static String MOSCOW_VNUKOVO_VKO = "Moscow Vnukovo (VKO)";
    public static String MOSCOW = "Moscow";
    public static String TURIN = "Turin";
    public static int SHORT_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.short"));
    public static int LONG_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.long"));
    public static int DEFAULT_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.default"));
}
