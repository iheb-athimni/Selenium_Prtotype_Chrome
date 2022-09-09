package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue ="StepsDefinition",tags = "@testAll")

public class TestRunner {
    
    @AfterClass
    public static void sendMailTest() throws IOException {
//        String rapportPath;
        SendMailFromOutlook sendTheMail = new SendMailFromOutlook();
//        zipClass zipClasstest = new zipClass();
//        rapportPath = zipClasstest.executeTasks();
        sendTheMail.main();

    }

}
