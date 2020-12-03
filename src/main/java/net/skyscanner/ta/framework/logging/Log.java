package net.skyscanner.ta.framework.logging;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;

public final class Log {

    private static final Logger LOGGER = Logger.getLogger("custom-logger");

    static {
        Path pathToLogConfig = Paths.get("src/main/resources/log4j.properties");
        String absolutePath = pathToLogConfig.toAbsolutePath().toString();
        PropertyConfigurator.configureAndWatch(absolutePath);
    }

    private Log() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", Log.class));
    }

    public static void addAppender(Appender appender) {
        LOGGER.addAppender(appender);
    }

    public static void removeAppender(Appender appender) {
        LOGGER.removeAppender(appender);
    }

    public static void trace(Object message) {
        LOGGER.trace(message);
    }

    public static void debug(Object message) {
        LOGGER.debug(message);
    }

    public static void info(Object message) {
        LOGGER.info(message);
    }

    public static void warn(Object message) {
        LOGGER.warn(message);
    }

    public static void error(Object message, Throwable exception) {
        LOGGER.error(message, exception);
    }

    public static void fatal(Object message, Throwable exception) {
        LOGGER.fatal(message, exception);
    }
}
