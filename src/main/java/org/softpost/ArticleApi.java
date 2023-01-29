package org.softpost;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ArticleApi extends Api {
    public ArticleApi(){

    }
    public Response getArticles(){
        return RestAssured.get("/posts/1");
    }


    //You can use request specification to avoid duplicate code
    public Response postArticle(String payload){
        return  RestAssured.given()
                .header("Authorization", "Bearer XTZYSHBS")
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/posts");
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