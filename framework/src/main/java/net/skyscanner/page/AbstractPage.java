package net.skyscanner.page;

import net.skyscanner.service.TestDataReader;

public abstract class AbstractPage {
    public static String getHomepageUrl() {
        return TestDataReader.getTestData("testData.home.url");
    }
}
