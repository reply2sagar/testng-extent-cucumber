import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.tools.ant.util.FileUtils;
import org.testng.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest implements IInvokedMethodListener {
    private static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUp() {
        // create an instance of the ExtentReports class
        BaseTest.extent = new ExtentReports();
        // configure the report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent.html");
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // code to be executed before a test method is invoked
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @BeforeMethod
    public void setupMethod(Method method) {
        test = extent.createTest(method.getName());
    }

    //hello
    @AfterMethod
    public void logResult(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            test.fail("failed the test");
        }else if (testResult.getStatus() == ITestResult.SUCCESS) {
            test.pass("passed the test");
        }
    }

    @BeforeTest
    public void setupTest(){
    }

    @AfterSuite
    public void tearDown() {
        BaseTest.extent.flush();
    }
}
