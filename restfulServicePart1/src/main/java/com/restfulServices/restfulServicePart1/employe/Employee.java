package com.restfulServices.restfulServicePart1.employe;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@ApiModel(description = "Employee details")
public class Employee {
    @ApiModelProperty(notes = "Should be unique")
    Integer id;

    @ApiModelProperty(notes = "Should be of string type")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2)
    String name;

    @ApiModelProperty(notes = "Should be between 18 to 60")
    @Min(value = 18)
    @Max(value = 60)
    Integer age;

    protected Employee(){

    }
    Employee(Integer id, String name, Integer age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
