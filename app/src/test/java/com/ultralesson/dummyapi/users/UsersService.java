package com.ultralesson.dummyapi.users;

import com.ultralesson.dummyapi.get.GetAllUsersResponse;
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
}
