package cucumbertests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "cucumbertests.Listener" },
        features = "target/test-classes/APIFeatures.feature",
        glue="org.softpost"
    )
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {}
