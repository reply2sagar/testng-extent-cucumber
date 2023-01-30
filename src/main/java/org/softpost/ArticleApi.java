package org.softpost;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.log.LogRepository;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static io.restassured.config.RestAssuredConfig.config;

public class ArticleApi extends Api {
    Response response;
    public ArticleApi(){

    }
    public Response getArticles(){
        //String log = RestAssured.given().log().all().when().get("/some/resource").then().extract().log().toString();

        return RestAssured.given().log().all().get("/posts/1");
    }

    //You can use request specification to avoid duplicate code
    public Response postArticle(String payload)  {

        //LogRepository logRepository = new LogRepository();
        //RestAssured.filters(new ResponseLoggingFilter(LogDetail.COOKIES),new RequestLoggingFilter(LogDetail.ALL));
        //RestAssured.filters(new RequestLoggingFilter(logRepository), new ResponseLoggingFilter(logRepository));

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PrintStream ps = null;
//        try {
//            ps = new PrintStream(byteArrayOutputStream, true, StandardCharsets.UTF_8.name());
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//        RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(ps));

//        PrintStream fileOutPutStream = null;
//        try {
//            fileOutPutStream = new PrintStream(new File("somefile.txt"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(ps));

        RequestSpecification rs = RestAssured.given().log().all()
                .header("Authorization", "Bearer XTZYSHBS")
                .contentType(ContentType.JSON)
                .body(payload);

        //System.out.println(rs.then().log());


        response = rs.post("/posts");
        //System.out.println("MMMMMM" + logRepository.getRequestLog() + "XXXX");

        //List<String> logs = logRepository.getRequestLog();

//        String output = byteArrayOutputStream.toString("UTF-8");
//        System.out.println("START" + output + "END");

        return  response;
    }

    public Response deleteArticle(String id){
        return  RestAssured.given()
                .header("Authorization", "Bearer XTZYSHBS")
                .contentType(ContentType.JSON)
                .delete("/resources/{id}", id);
    }

    public Response putArticle(String payload){
        return  RestAssured.given()
                .header("Authorization", "Bearer XTZYSHBS")
                .contentType(ContentType.JSON)
                .body(payload)
                .put("/posts");
    }

}