package com.javadevelopersguide.springboot.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@RestController
@EnableAutoConfiguration
public class EmpController {
    @RequestMapping("/emp_data")
   @ResponseBody

    public List<Employee> emp_data() {
        return Arrays.asList(
                new Employee(1,"rishab","1L"),
                new Employee(2,"mohit","2L"));
    }
}
