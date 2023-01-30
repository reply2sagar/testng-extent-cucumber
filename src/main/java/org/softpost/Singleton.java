package org.softpost;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Singleton{
    private static Singleton instance;
    public ExtentReports extent;
    private String error;

    private ByteArrayOutputStream byteArrayOutputStream;

    public String getRawLogs() {
        try {
            String log = byteArrayOutputStream.toString("UTF-8");
            byteArrayOutputStream.reset();//cleans the stream
            return log;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    // public StringWriter logs ;
    private Singleton() {
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent.html");
        extent.attachReporter(htmlReporter);

        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = null;
        try {
            ps = new PrintStream(byteArrayOutputStream, true, StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(ps));

        //        String output = byteArrayOutputStream.toString("UTF-8");
//        System.out.println("START" + output + "END");

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
           // instance.logs = new StringWriter();
        }
        return instance;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}