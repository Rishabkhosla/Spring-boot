package com.example.demo.controller;

import com.example.demo.model.Inspection_Form;
import com.example.demo.model.User;
import com.example.demo.service.FormService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    UserService user_service;

    @PostMapping("/")
    public HttpStatus authenticate(@RequestBody User user){
        Boolean flag= user_service.findbycredentials(user);
        if(flag==true){
            System.out.println(HttpStatus.OK);
            return HttpStatus.OK;
        }
        else{
            System.out.println(HttpStatus.NOT_FOUND);
            return HttpStatus.NOT_FOUND;
        }
    }

}
