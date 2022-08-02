package com.ultralesson.dummyapi.posts;

import com.ultralesson.dummyapi.create.CreatePostRequestBody;
import com.ultralesson.dummyapi.create.PostResponse;
import io.restassured.response.Response;

public class PostsService {
    public PostResponse createPost(CreatePostRequestBody body){
        Response response=new PostsClient().createPost(body);
        PostResponse postResponse=response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }

    public PostResponse getPost(String id){
        Response response=new PostsClient().getPost(id);
        PostResponse postResponse=response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }
}
