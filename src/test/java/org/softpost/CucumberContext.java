package org.softpost;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class CucumberContext {
    private  ExtentReports extent;
    private ExtentTest test;
    public Map<String, Object> map ;


     public CucumberContext(){
        System.out.println("Cucumbercontext");
        extent = Singleton.getInstance().extent;
        // configure the report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent.html");
        extent.attachReporter(htmlReporter);
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
