package com.ultralesson.dummyapi.posts.create;

import com.ultralesson.dummyapi.posts.models.CreatePostRequestBody;
import com.ultralesson.dummyapi.posts.models.PostResponse;
import com.ultralesson.dummyapi.posts.services.PostsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePostTests {
    private PostsService postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsService();
    }

    @Test(groups={"sanity","post"})
    public void shouldCreatePost(){
        CreatePostRequestBody body=new CreatePostRequestBody.Builder().build();
        PostResponse postResponse= postsService.createPost(body);
        postResponse.assertPost(body);
    }
}
