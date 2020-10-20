package constants;

import service.TimeoutDataReader;

public interface Timeout {

    int SHORT_TIMEOUT_MILLIS = Integer.parseInt(TimeoutDataReader.getTimeoutData("SHORT_TIMEOUT_MILLIS"));
    int LONG_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("LONG_TIMEOUT_SECONDS"));
    int DEFAULT_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("DEFAULT_TIMEOUT_SECONDS"));
}
