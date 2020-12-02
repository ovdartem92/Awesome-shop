package net.skyscanner.ta.framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.Objects;

import static utils.StringUtils.convertTime;

public class SuiteListener implements ISuiteListener {
    private final Logger logger = LogManager.getRootLogger();
    private long startTimeOfSuite;

    @Override
    public void onStart(ISuite suite) {
        Objects.requireNonNull(suite, "ISuite cannot be null.");
        startTimeOfSuite = System.currentTimeMillis();
        logger.debug(" Test suite {} started", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Objects.requireNonNull(suite, "ISuite cannot be null.");
        String timeOfSuiteRunning = convertTime(System.currentTimeMillis() - startTimeOfSuite);
        logger.debug("Test suite - {} finished", suite.getName());
        logger.debug("Test suite {} was running for {}", suite.getName(), timeOfSuiteRunning);
    }
}
