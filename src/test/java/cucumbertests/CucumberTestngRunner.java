package cucumbertests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//Custom listener is required because we want to grab the exception thrown by steps
@CucumberOptions(
        plugin = { "cucumbertests.Listener" },
        features = "target/test-classes/APIFeatures.feature",
        glue="org.softpost",
        tags= "@S1"
    )
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {}
