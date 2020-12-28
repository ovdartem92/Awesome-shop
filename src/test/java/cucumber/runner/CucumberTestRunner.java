package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = "cucumber.runner",
        features = "classpath:cucumber/runner/features"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
