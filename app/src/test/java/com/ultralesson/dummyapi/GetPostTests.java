package com.ultralesson.dummyapi;

import com.ultralesson.dummyapi.create.PostResponse;
import com.ultralesson.dummyapi.posts.PostsService;
import com.ultralesson.dummyapi.users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPostTests {
    private PostsService postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsService();
    }

    @Test
    public void shouldGetPostsById(){
        String id="62e8fd3ba083ba06aac59ace";
        PostResponse postResponse= postsService.getPost(id);
        Assert.assertEquals(postResponse.getText(),"this is a text field");
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }
}
