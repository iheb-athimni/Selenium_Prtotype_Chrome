package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue ="StepsDefinition",tags = "@testAll",
        monochrome = true,
        plugin = { "pretty", "json:target/cucumber-reports/test_automation_report.json"})
public class TestRunner {
}
