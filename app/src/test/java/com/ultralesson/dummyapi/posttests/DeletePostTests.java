package com.ultralesson.dummyapi.posttests;

import com.ultralesson.dummyapi.posts.PostsClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostTests {
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){
        postsClient=new PostsClient();
    }
    @Test
    public void shouldDeletePosts(){
        String id="62e9171e28b96e5e8426a9c2";
        Response response= postsClient.deletePost(id);
        response
                .then()
                .statusCode(200)
                .log().body()
                .body("id", Matchers.equalTo(id));
    }
}
