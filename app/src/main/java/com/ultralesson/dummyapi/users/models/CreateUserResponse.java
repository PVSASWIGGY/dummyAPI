package com.ultralesson.dummyapi.users.models;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserResponse {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String registerDate;
    private String phone;
    private String picture;
    private String updatedDate;
    @Setter
    private int statusCode;
    private Location location;

    public void assertUser(CreateUserRequestBody body) {
        Assert.assertEquals(this.firstName,body.getFirstName());
        Assert.assertEquals(this.lastName,body.getLastName());
        Assert.assertEquals(this.email,body.getEmail());
        Assert.assertEquals(this.statusCode,200);
    }

    @Getter
    private static class Location {
        private String street;
        private String city;
        private String state;
        private String country;
        private String timezone;
    }
}
