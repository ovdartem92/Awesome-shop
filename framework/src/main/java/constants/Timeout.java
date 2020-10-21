package constants;

import enums.DefaultTimeoutValues;
import service.TimeoutDataReader;

public interface Timeout {

    int SHORT_TIMEOUT_MILLIS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.short"));
    int LONG_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.long"));
    int DEFAULT_TIMEOUT_SECONDS = Integer.parseInt(TimeoutDataReader.getTimeoutData("timeout.default"));

}
