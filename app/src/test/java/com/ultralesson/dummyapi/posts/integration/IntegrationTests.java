package com.ultralesson.dummyapi.posts.integration;

import com.ultralesson.dummyapi.posts.clients.PostsClient;
import com.ultralesson.dummyapi.posts.models.CreatePostRequestBody;
import com.ultralesson.dummyapi.posts.models.PostResponse;
import com.ultralesson.dummyapi.posts.services.PostsService;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IntegrationTests {
    private PostsService postsService;
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsService();
        postsClient=new PostsClient();
    }

    @Test(groups={"sanity","post"})
    public void shouldCreateAndDeletePost(){
        CreatePostRequestBody body=new CreatePostRequestBody.Builder().build();
        PostResponse postResponse=postsService.createPost(body);
        postResponse.assertPost(body);
        String id=postResponse.getId();
        Response response= postsClient.deletePost(id);
        response
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(id));
    }
}
