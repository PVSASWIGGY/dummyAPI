package com.ultralesson.dummyapi.users.get;

import com.ultralesson.dummyapi.users.models.GetAllUsersResponse;
import com.ultralesson.dummyapi.users.services.UsersService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GetUsersTests {
    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }

    @Test(groups={"sanity","user"})
    public void shouldGetAllUsers(){
        GetAllUsersResponse usersResponse=usersService.getAllUsersResponse();
        Assert.assertEquals(usersResponse.getStatusCode(),200);
        Assert.assertEquals(usersResponse.getDataList().size(),10);
    }

    @Test(groups={"sanity","user"})
    public void shouldGetUsersCreatedByMe(){
        GetAllUsersResponse usersResponse=usersService.getAllUsersByMeResponse();
        Assert.assertEquals(usersResponse.getStatusCode(),200);
//        Assert.assertEquals(usersResponse.getDataList().size(),1);
    }
}