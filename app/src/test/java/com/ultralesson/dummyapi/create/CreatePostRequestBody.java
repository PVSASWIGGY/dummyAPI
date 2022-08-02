package com.ultralesson.dummyapi.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatePostRequestBody {
    private String text;
    private String image;
    private String owner;
    private List<String> tags;
    private int likes;

    public CreatePostRequestBody(Builder builder) {
        this.text= builder.text;
        this.image=builder.image;
        this.likes=builder.likes;
        this.owner=builder.owner;
        this.tags=builder.tags;
    }

    public static class Builder{
        private String text;
        private String image;
        private String owner;
        @JsonProperty("tags")
        private List<String> tags;
        private int likes;
        public Builder(){
            text="this is a text field";
            image="https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Google_Images_2015_logo.svg/800px-Google_Images_2015_logo.svg.png";
            likes=0;
            owner="62e8fc28a083badbbfc599de";
            tags=new ArrayList<>();
        }

        public CreatePostRequestBody build(){
            CreatePostRequestBody requestBody=new CreatePostRequestBody(this);
            return requestBody;
        }

    }
}