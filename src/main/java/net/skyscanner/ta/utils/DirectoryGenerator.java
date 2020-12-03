package net.skyscanner.ta.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Objects;

import static java.lang.String.format;

public final class DirectoryGenerator {

    private static final Logger LOGGER = LogManager.getLogger();

    private DirectoryGenerator() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", DirectoryGenerator.class));
    }

    public static String create(String pathToDirectory) {
        Objects.requireNonNull(pathToDirectory, "Path to directory cannot be null.");
        File folder = new File(pathToDirectory);
        boolean successFlag = folder.mkdirs();
        if (!successFlag) {
            LOGGER.warn("Failed to create dirs using the following path: {}", pathToDirectory);
        }
        return folder.getAbsolutePath();
    }
}
