package com.restfulServices.restfulServicePart1.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    //URI versioning
    @GetMapping("v1/person")
    public Person1 person1(){
        return new Person1("Nitin");
    }
    @GetMapping("v2/person")
    public Person2 person2(){
        return new Person2(new Name("Nitin", "khandelwal"));
    }

    //Request Parameter versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public Person1 param1(){
        return new Person1("Nitin");
    }
    @GetMapping(value = "/person/param", params = "version=2")
    public Person2 param2(){
        return new Person2(new Name("Nitin", "khandelwal"));
    }

    //Custom Header Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public Person1 header1(){
        return new Person1("Nitin");
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public Person2 header2(){
        return new Person2(new Name("Nitin", "khandelwal"));
    }

    //MimeType Versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public Person1 produces1(){
        return new Person1("Nitin");
    }
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public Person2 produces2(){
        return new Person2(new Name("Nitin", "khandelwal"));
    }
}
