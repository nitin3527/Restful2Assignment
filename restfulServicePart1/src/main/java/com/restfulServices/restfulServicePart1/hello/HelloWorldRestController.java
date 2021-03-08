package com.restfulServices.restfulServicePart1.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldRestController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public WelcomeToSpring helloWorld(){
        return new WelcomeToSpring("Welcome to spring boot");
    }

    @GetMapping(path = "/hello-employee")
    public String helloWorldInternalization(@RequestParam String userName){
        return messageSource.getMessage("good.morning.message",null,
                LocaleContextHolder.getLocale()) + " " +  userName;
    }

}
