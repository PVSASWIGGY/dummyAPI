package com.ultralesson.dummyapi.users.clients;

import com.ultralesson.dummyapi.users.models.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    private String appId="62e91453bbc7a02d6fb21d0a";
    public Response getAllUsersResponse() {
        return given()
                    .queryParam("limit",10)
                .header("app-id",appId)
                .when()
                    .get("https://dummyapi.io/data/v1/user");
    }

    public Response getAllUsersByMeResponse() {
        return given()
                    .queryParam("created",1)
                .header("app-id",appId)
                .when()
                    .get("https://dummyapi.io/data/v1/user");
    }

    public Response createUser(CreateUserRequestBody body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", appId)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");
        response
                .then()
                .log().body();
        return response;
    }
}
