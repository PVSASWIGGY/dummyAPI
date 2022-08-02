package com.ultralesson.dummyapi.users;

import com.ultralesson.dummyapi.create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UsersClient {
    public Response getAllUsersResponse() {
        return given()
                    .queryParam("limit",10)
                .header("app-id","62e7782cfe76a1795f83ec17")
                .when()
                    .get("https://dummyapi.io/data/v1/user");
    }

    public Response getAllUsersByMeResponse() {
        return given()
                    .queryParam("created",1)
                .header("app-id","62e7782cfe76a1795f83ec17")
                .when()
                    .get("https://dummyapi.io/data/v1/user");
    }

    public Response createUser(CreateUserRequestBody body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "62e7782cfe76a1795f83ec17")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");
        response
                .then()
                .log().body();
        return response;
    }
}
