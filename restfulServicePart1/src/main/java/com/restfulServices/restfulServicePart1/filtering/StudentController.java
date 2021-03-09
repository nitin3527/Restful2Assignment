package com.restfulServices.restfulServicePart1.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @ApiModelProperty(notes = "Single student detail")
    @GetMapping("/students")
    public Student getAllStudents(){
        return new Student("NK563", 23,"nk789456");
    }
    @ApiModelProperty(notes = "student list")
    @GetMapping("/student-list")
    public MappingJacksonValue getAllStudentList(){
        List<Student> studList = Arrays.asList(new Student("mk56",26,"hjvhvjv"),
                new Student("yk456",18,"bshbsjv") );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("StudentFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(studList);
        mapping.setFilters(filters);
        return mapping;
    }
}
