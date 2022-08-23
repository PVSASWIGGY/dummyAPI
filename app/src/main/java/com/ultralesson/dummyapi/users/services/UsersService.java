package com.ultralesson.dummyapi.users.services;

import com.ultralesson.dummyapi.users.clients.UsersClient;
import com.ultralesson.dummyapi.users.models.CreateUserErrorResponse;
import com.ultralesson.dummyapi.users.models.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.models.CreateUserResponse;
import com.ultralesson.dummyapi.users.models.GetAllUsersResponse;
import io.restassured.response.Response;

public class UsersService {
    public GetAllUsersResponse getAllUsersResponse(){
        Response response=new UsersClient().getAllUsersResponse();
        GetAllUsersResponse usersResponse= response.as(GetAllUsersResponse.class);
        usersResponse.setStatusCode(response.statusCode());
        return usersResponse;
    }

    public GetAllUsersResponse getAllUsersByMeResponse() {
        Response response=new UsersClient().getAllUsersByMeResponse();
        GetAllUsersResponse usersResponse= response.as(GetAllUsersResponse.class);
        usersResponse.setStatusCode(response.statusCode());
        return usersResponse;
    }

    public CreateUserResponse createUser(CreateUserRequestBody body){
        Response response=new UsersClient().createUser(body);
        CreateUserResponse userResponse=response.as(CreateUserResponse.class);
        userResponse.setStatusCode(response.getStatusCode());
        return userResponse;
    }

    public CreateUserErrorResponse CreateUser(CreateUserRequestBody body){
        Response response=new UsersClient().createUser(body);
        CreateUserErrorResponse errorResponse=response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.getStatusCode());
        return errorResponse;
    }

}
