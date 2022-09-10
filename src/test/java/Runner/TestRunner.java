package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.AfterClass;
import org.springframework.beans.factory.annotation.Value;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue ="StepsDefinition",tags = "@testAll",
        monochrome = true,
        plugin = { "pretty", "json:target/cucumber-reports/test_automation_report.json"})

public class TestRunner {

    public static void sendMailTest() throws IOException {
        SendMailFromOutlook sendTheMail = new SendMailFromOutlook();
        System.out.println("my email class is running");
        sendTheMail.sendingMail();

    }

}
