package com.ultralesson.dummyapi.users.models;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserErrorResponse {
    private String error;
    private Data data;
    @Setter
    private int statusCode;

    public void assertResponse() {
        Assert.assertEquals(this.statusCode,400);
        Assert.assertEquals(this.error,"BODY_NOT_VALID");
        Assert.assertEquals(this.data.getEmail(),"Email already used");
    }

    @Getter
    private static class Data {
        private String email;
    }
}
