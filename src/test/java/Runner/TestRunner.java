package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue ="StepsDefinition",tags = "@testAll",
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports/test_automation_report.html" })

public class TestRunner {
    
    @AfterClass
    public static void sendMailTest() throws IOException {
        SendMailFromOutlook sendTheMail = new SendMailFromOutlook();
        sendTheMail.main();
    }

}
