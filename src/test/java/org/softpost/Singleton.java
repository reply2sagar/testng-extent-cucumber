package org.softpost;

import com.aventstack.extentreports.ExtentReports;

public class Singleton{
    private static Singleton instance;
    public ExtentReports extent;

    private String error;
    private Singleton() {
        extent = new ExtentReports();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
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