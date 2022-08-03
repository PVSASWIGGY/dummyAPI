package com.ultralesson.dummyapi.posttests;

import com.ultralesson.dummyapi.models.CreatePostRequestBody;
import com.ultralesson.dummyapi.models.PostResponse;
import com.ultralesson.dummyapi.posts.PostsService;
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
