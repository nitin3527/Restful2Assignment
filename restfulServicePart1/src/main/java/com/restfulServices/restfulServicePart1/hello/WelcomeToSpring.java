package com.restfulServices.restfulServicePart1.hello;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Welcome to spring")
public class WelcomeToSpring {
    private String message;
    WelcomeToSpring(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
