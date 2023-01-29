package org.softpost;

import com.aventstack.extentreports.ExtentReports;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.*;

public class BaseStepDef {
    CucumberContext context;
    static ExtentReports extent;
    public BaseStepDef(CucumberContext context){
        this.context = context;
        extent = context.getExtent();
    }

    @BeforeAll
    public static void setupBeforeAll(){
        System.out.println("Running beforeAll hook");
    }

    @AfterAll
    public static void setupAfterAll(){
        System.out.println("Running afterAll hook");
        Singleton.getInstance().extent.flush();
    }

    @Before
    public void setupBefore(Scenario scenario){
        System.out.println("Running before hook");
        Singleton.getInstance().setError("");
        context.setTest(extent.createTest(scenario.getName()));
        context.getTest().assignCategory(scenario.getSourceTagNames().toArray(new String[0]));
    }

    @After
    public void setupAfter(Scenario scenario){
        System.out.println("Running after hook");
        context.getTest().info(scenario.getName());
        context.getTest().info("Status : " + scenario.getStatus().toString());
        if (scenario.isFailed()) {
            // take screenshot or do some other cleanup
            context.getTest().fail("Failed Scenario" + Singleton.getInstance().getError());
        }
    }
}
