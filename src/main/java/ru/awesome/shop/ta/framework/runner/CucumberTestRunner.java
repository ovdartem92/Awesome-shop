package ru.awesome.shop.ta.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;
import ru.awesome.shop.ta.framework.listeners.TestListener;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty.html"},
        monochrome = true,
        tags = "@smoke",
        glue = "awesome.shop.tests.cucumber",
        features = "src/test/resources/features"

)
@Listeners({TestListener.class, SuiteListener.class})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}