package org.softpost;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

import utilities.ConfigManager;

import java.io.PrintStream;
import java.io.StringWriter;

public class Api {

    public Api(){
        //RestAssured.baseURI = "";
       // RestAssured.baseURI = ConfigManager.getInstance().getProperties().getProperty("server");
        RestAssured.baseURI = ConfigManager.prop.getProperty("server");
       // RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(new PrintStream(new WriterOutputStream(new StringWriter()))));
        //RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(new PrintStream(new WriterOutputStream(Singleton.getInstance().logs))));



    }

}