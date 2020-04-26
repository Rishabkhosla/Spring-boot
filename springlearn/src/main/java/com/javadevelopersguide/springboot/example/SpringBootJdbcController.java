package com.javadevelopersguide.springboot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SpringBootJdbcController {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/show")

    public String index(){

        jdbc.execute(" create table dummy_tb(id Int)");
        return"data inserted Successfully";
    }
}
