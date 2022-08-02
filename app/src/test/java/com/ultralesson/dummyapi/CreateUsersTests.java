package com.ultralesson.dummyapi;

import com.ultralesson.dummyapi.create.CreateUserErrorResponse;
import com.ultralesson.dummyapi.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.create.CreateUserResponse;
import com.ultralesson.dummyapi.users.UsersService;
import lombok.Getter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUsersTests {
    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }
    @Test
    public void shouldCreateUser(){
        CreateUserRequestBody body=new CreateUserRequestBody.Builder().build();
        CreateUserResponse userResponse= usersService.createUser(body);
        userResponse.assertUser(body);
    }

    @Test
    public void shouldNotCreateUserWithDuplicateEmail(){
        CreateUserRequestBody body=new CreateUserRequestBody.Builder().email("dummy.user@gmail.com").build();
        CreateUserErrorResponse errorResponse= usersService.CreateUser(body);
        errorResponse.assertResponse();
    }
}
