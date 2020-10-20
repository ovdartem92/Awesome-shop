package constants;

import enums.DefaultTimeoutValues;
import service.TimeoutDataReader;

public interface Timeout {

    int SHORT_TIMEOUT_MILLIS = TimeoutDataReader.getTimeoutValue(DefaultTimeoutValues.SHORT_TIMEOUT_MILLIS);
    int LONG_TIMEOUT_SECONDS = TimeoutDataReader.getTimeoutValue(DefaultTimeoutValues.LONG_TIMEOUT_SECONDS);
    int DEFAULT_TIMEOUT_SECONDS = TimeoutDataReader.getTimeoutValue(DefaultTimeoutValues.DEFAULT_TIMEOUT_SECONDS);
}
