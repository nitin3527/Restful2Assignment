package com.restfulServices.restfulServicePart1.versioning;

public class Person1 {
    String name;

    public Person1(){
        super();
    }
    public Person1(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
