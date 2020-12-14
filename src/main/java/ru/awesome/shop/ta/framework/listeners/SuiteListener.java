package ru.awesome.shop.ta.framework.listeners;

import ru.awesome.shop.ta.framework.logging.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import ru.awesome.shop.ta.utils.StringUtils;

import java.util.Objects;

public class SuiteListener implements ISuiteListener {
    private long startTimeOfSuite;

    @Override
    public void onStart(ISuite suite) {
        Objects.requireNonNull(suite, "ISuite cannot be null.");
        startTimeOfSuite = System.currentTimeMillis();
        Log.info(String.format("Test suite %s started", suite.getName()));
    }

    @Override
    public void onFinish(ISuite suite) {
        Objects.requireNonNull(suite, "ISuite cannot be null.");
        String timeOfSuiteRunning = StringUtils.convertTime(System.currentTimeMillis() - startTimeOfSuite);
        Log.info(String.format("Test suite %s finished", suite.getName()));
        Log.info(String.format("Test suite %s was running for %s", suite.getName(), timeOfSuiteRunning));
    }
}
