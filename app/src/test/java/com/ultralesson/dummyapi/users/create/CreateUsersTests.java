package com.ultralesson.dummyapi.users.create;

import com.ultralesson.dummyapi.users.models.CreateUserErrorResponse;
import com.ultralesson.dummyapi.users.models.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.models.CreateUserResponse;
import com.ultralesson.dummyapi.users.services.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUsersTests {
    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }
    @Test(groups={"sanity"})
    public void shouldCreateUser(){
        CreateUserRequestBody body=new CreateUserRequestBody.Builder().build();
        CreateUserResponse userResponse= usersService.createUser(body);
        userResponse.assertUser(body);
    }

    @Test(groups={"sanity"})
    public void shouldNotCreateUserWithDuplicateEmail(){
        CreateUserRequestBody body=new CreateUserRequestBody.Builder().email("dummy.user@gmail.com").build();
        CreateUserErrorResponse errorResponse= usersService.CreateUser(body);
        errorResponse.assertResponse();
    }
}