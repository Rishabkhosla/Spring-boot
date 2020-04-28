package com.example.demo;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.example.demo.ServiceStudent;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration
@Component
public class StudentController {

    @Autowired
    private ServiceStudent service;


    @GetMapping("/student_description")
    @CrossOrigin
    public Student_description description(){

        return service.stu_des();
    }

    @GetMapping("/student_date")
    @CrossOrigin
    public List<Student> student_date(){

        return service.data();
    }

    @GetMapping("/filter_student_data")
    @CrossOrigin

    public Student retriveUser()
    {
        return service.datafilter(2);
    }

//    @PostMapping("/users")
//    public void createUser(@RequestBody User user)
//    {
//        User sevedUser=service.save(user);
//    }


}



