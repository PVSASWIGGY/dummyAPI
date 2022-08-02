package com.ultralesson.dummyapi;

import com.ultralesson.dummyapi.get.GetAllUsersResponse;
import com.ultralesson.dummyapi.users.UsersClient;
import com.ultralesson.dummyapi.users.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetUsersTests {
    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }

    @Test
    public void shouldGetAllUsers(){
        GetAllUsersResponse usersResponse=usersService.getAllUsersResponse();
        Assert.assertEquals(usersResponse.getStatusCode(),200);
        Assert.assertEquals(usersResponse.getDataList().size(),10);
    }

    @Test
    public void shouldGetUsersCreatedByMe(){
        GetAllUsersResponse usersResponse=usersService.getAllUsersByMeResponse();
        Assert.assertEquals(usersResponse.getStatusCode(),200);
        Assert.assertEquals(usersResponse.getDataList().size(),CreateUsersTests.getCountOfUsersByMe());
    }
}