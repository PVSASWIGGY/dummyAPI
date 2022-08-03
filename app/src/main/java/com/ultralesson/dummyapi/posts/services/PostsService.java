package com.ultralesson.dummyapi.posts.services;

import com.ultralesson.dummyapi.posts.clients.PostsClient;
import com.ultralesson.dummyapi.posts.models.CreatePostRequestBody;
import com.ultralesson.dummyapi.posts.models.PostResponse;
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
