package ru.awesome.shop.ta.utils;

import com.epam.reportportal.message.ReportPortalMessage;
import ru.awesome.shop.ta.framework.logging.Log;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static java.lang.String.format;

public class ReportPortalManager {

    private ReportPortalManager() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ReportPortalManager.class));
    }

    public static void post(File screenshot) {
        Objects.requireNonNull(screenshot, "Screenshot file cannot be null.");
        ReportPortalMessage screenshotMessage = null;
        try {
            screenshotMessage = new ReportPortalMessage(screenshot, "");
        } catch (IOException e) {
            Log.warn("Failed to create a report portal message.");
        }
        Log.info(screenshotMessage);
        Log.info("ReportPortalMessage was posted to the Report Portal");
    }
}
