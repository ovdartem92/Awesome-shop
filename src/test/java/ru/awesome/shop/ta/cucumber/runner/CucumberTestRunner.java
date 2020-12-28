package ru.awesome.shop.ta.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "ru.awesome.shop.ta.cucumber",
        features = "src/test/resources/features"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
