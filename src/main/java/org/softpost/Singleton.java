package org.softpost;

import com.aventstack.extentreports.ExtentReports;

import java.io.StringWriter;

public class Singleton{
    private static Singleton instance;
    public ExtentReports extent;

    private String error;
   // public StringWriter logs ;
    private Singleton() {
        extent = new ExtentReports();
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