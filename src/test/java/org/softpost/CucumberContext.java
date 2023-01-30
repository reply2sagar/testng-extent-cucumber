package org.softpost;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

public class CucumberContext {
    private  ExtentReports extent;
    private ExtentTest test;
    public Map<String, Object> map ;

     public CucumberContext(){
        extent = Singleton.getInstance().extent;
        map = new HashMap<>();
    }

    public ExtentReports getExtent(){
        return extent;
    }

    public void setTest(ExtentTest test){
        this.test = test;
    }

    public ExtentTest getTest(){
       return this.test;
    }

}
