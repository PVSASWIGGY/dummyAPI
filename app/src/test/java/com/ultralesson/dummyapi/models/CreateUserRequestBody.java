package com.ultralesson.dummyapi.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;

    public CreateUserRequestBody(Builder builder) {
        this.firstName= builder.firstName;
        this.lastName= builder.lastName;
        this.email= builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        public Builder(){
            this.firstName="dummy";
            this.lastName="user";
            this.email= UUID.randomUUID()+"@gmail.com";
        }
        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public CreateUserRequestBody build(){
            CreateUserRequestBody requestBody=new CreateUserRequestBody(this);
            return requestBody;
        }
    }
}
