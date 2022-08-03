package com.ultralesson.dummyapi.posts;

import com.ultralesson.dummyapi.models.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {
    private String appId="62e91453bbc7a02d6fb21d0a";
    public Response createPost(CreatePostRequestBody body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", appId)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
        response
                .then()
                .log().body();
        return response;
    }

    public Response getPost(String id){
        return given()
                    .header("app-id",appId)
                    .pathParam("id",id)
                .when()
                    .get("https://dummyapi.io/data/v1/post/{id}");
    }

    public Response deletePost(String id){
        return given()
                    .header("app-id",appId)
                    .pathParam("id",id)
                .when()
                    .delete("https://dummyapi.io/data/v1/post/{id}");
    }
}
