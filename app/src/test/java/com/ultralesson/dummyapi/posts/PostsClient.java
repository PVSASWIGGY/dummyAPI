package com.ultralesson.dummyapi.posts;

import com.ultralesson.dummyapi.create.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response createPost(CreatePostRequestBody body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "62e7782cfe76a1795f83ec17")
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
                    .header("app-id","62e7782cfe76a1795f83ec17")
                    .pathParam("id",id)
                .when()
                    .get("https://dummyapi.io/data/v1/post/{id}");
    }
}
