package com.restfulServices.restfulServicePart1.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
@JsonFilter("StudentFilter")
public class Student {

    String userName;
    Integer age;
    //@JsonIgnore  //un-comment it for static filtering
    String password;
    public Student(String userName, Integer age, String password){
        this.userName = userName;
        this.age = age;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

}
