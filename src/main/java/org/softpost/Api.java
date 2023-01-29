package org.softpost;

import io.restassured.RestAssured;

public class Api {

    public Api(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // RestAssured.baseURI = ConfigManager.getInstance().getProperties().getProperty("server");


    }

}