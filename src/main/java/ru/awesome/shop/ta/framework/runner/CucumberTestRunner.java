package ru.awesome.shop.ta.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import ru.awesome.shop.ta.framework.listeners.SuiteListener;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty.html"},
        monochrome = true,
        tags = "@all",
        glue = "awesome.shop.tests.ui.cucumber",
        features = "src/test/resources/features/api")
@Listeners({SuiteListener.class})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
