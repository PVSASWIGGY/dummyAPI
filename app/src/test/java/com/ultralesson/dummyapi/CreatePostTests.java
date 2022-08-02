package com.ultralesson.dummyapi;

import com.ultralesson.dummyapi.create.CreatePostRequestBody;
import com.ultralesson.dummyapi.create.PostResponse;
import com.ultralesson.dummyapi.posts.PostsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePostTests {
    private PostsService postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsService();
    }

    @Test
    public void shouldCreatePost(){
        CreatePostRequestBody body=new CreatePostRequestBody.Builder().build();
        PostResponse postResponse= postsService.createPost(body);
        postResponse.assertPost(body);
    }
}
