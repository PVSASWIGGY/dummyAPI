package com.ultralesson.dummyapi.posttests;

import com.ultralesson.dummyapi.models.PostResponse;
import com.ultralesson.dummyapi.posts.PostsService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPostTests {
    private PostsService postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsService();
    }

    @Test(groups={"sanity","post"})
    public void shouldGetPostsById(){
        String id="62e916382c2eccbd5c67fe86";
        PostResponse postResponse= postsService.getPost(id);
        Assert.assertEquals(postResponse.getText(),"this is a text field");
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }
}
