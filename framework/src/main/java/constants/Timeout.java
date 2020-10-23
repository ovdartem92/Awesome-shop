package constants;

import service.TimeoutDataReader;

public interface Timeout {
    int SHORT_TIMEOUT_SECONDS = getShortTimeoutSeconds();
    int LONG_TIMEOUT_SECONDS = getLongTimeoutSeconds();
    int DEFAULT_TIMEOUT_SECONDS = getDefaultTimeoutSeconds();

    static int getShortTimeoutSeconds() {
        if (System.getProperty("timeout.short") == null) {
            return 1;
        }
        return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.short"));
    }

    static int getLongTimeoutSeconds() {
        if (System.getProperty("timeout.long") == null) {
            return 15;
        }
        return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.long"));
    }

    static int getDefaultTimeoutSeconds() {
        if (System.getProperty("timeout.default") == null) {
            return 5;
        }
        return Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.default"));
    }
}